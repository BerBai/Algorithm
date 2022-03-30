package top100.slidingWindow;

/**
 * @author ber
 * @version 1.0
 * @date 22/3/30 11:37
 */
public class T008 {
    /**
     * 题：https://leetcode-cn.com/problems/2VG8Kg/
     * 求最短连续子数组长度，子数组和满足大于等于target
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            // 记录子数组和
            sum += nums[end];
            // 子数组和大于等于target，记录子数组长度
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                // 减去子数组靠前元素，重新计算最小子数组长度
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
