package top100.binarySearch;

import java.util.Arrays;

/**
 * @author ber
 * @version 1.0
 * @date 22/3/30 11:26
 */
public class T008 {
    /**
     * 题：https://leetcode-cn.com/problems/2VG8Kg/
     * 求最短连续子数组长度，子数组和满足大于等于target
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            // 目标值加上前缀和
            int s = target + sums[i - 1];
            // 二分查找，若存在值返回索引值；不存在，则返回 -插入位置
            int bound = Arrays.binarySearch(sums, s);
            // 不存在，转换为插入位置索引值
            if (bound < 0) {
                bound = -bound - 1;
            }
            // 计算大于等于target的最小连续数组长度
            if (bound <= n) {
                ans = Math.min(ans, bound - i + 1);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
