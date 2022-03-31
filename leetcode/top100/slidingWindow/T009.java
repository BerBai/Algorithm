package top100.slidingWindow;

/**
 * @author ber
 * @version 1.0
 * @date 22/3/31 12:06
 */
public class T009 {
    /**
     * 题：https://leetcode-cn.com/problems/ZVAVXX/
     * 求乘积小于k的连续子数组个数
     *
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int product = 1;
        int start = 0, end = 0;
        int len = nums.length;
        int ans = 0;
        while (end < len) {
            product *= nums[end];
            while (product >= k && start < end) {
                product /= nums[start++];
            }
            if (product < k) {
                // 滑动窗口的连续子数组刚好等于窗口大小
                ans += (end - start + 1);
            }
            end++;
        }
        return ans;
    }
}
