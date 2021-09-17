package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/16 10:53
 */
public class T213 {
    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 1) {
                return nums[0];
            } else if (n == 2) {
                return Math.max(nums[0], nums[1]);
            }
            return Math.max(func(nums, 0, n - 1), func(nums, 1, n));

        }

        public int func(int[] nums, int start, int end) {
            int[] dp = new int[end];
            dp[start] = nums[start];
            dp[start + 1] = Math.max(nums[start], nums[start + 1]);
            for (int i = start + 2; i < end; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
            return dp[end - 1];
        }
    }
}
