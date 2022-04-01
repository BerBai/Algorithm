package top100.preSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ber
 * @version 1.0
 * @date 22/4/1 11:17
 */
public class T010 {
    /**
     * 题：https://leetcode-cn.com/problems/QTMn0o/
     * 因为存在负数，所以滑动窗口的做法行不通（连续子数组和不再递增）
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        // 记录前缀和，sums[i] = sums[i-1] + nums[i-1]
        int[] sums = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        int ans = 0;
        for (int i = 0; i <= len; i++) {
            for (int j = i + 1; j <= len; j++) {
                if (sums[j] - sums[i] == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    // 优化

    /**
     * 前缀和：表示从开始位置，到数组中各项当前位置的所有项的和
     * 区间和：i到j之间的所有项的和
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {
        int len = nums.length;
        // 记录前缀和出现个数
        Map<Integer, Integer> preSumCnt = new HashMap<>();
        int preSum = 0;
        // i=0时 前缀和为0，出现一次
        preSumCnt.put(preSum, 1);
        int ans = 0;
        for (int num : nums) {
            preSum += num;
            // 前缀和 - 区间和 = 区间和左侧位置的前缀和，即
            ans += preSumCnt.getOrDefault(preSum - k, 0);
            preSumCnt.put(preSum, preSumCnt.getOrDefault(preSum, 0) + 1);
        }
        return ans;
    }
}
