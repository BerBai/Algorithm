package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/16 08:59
 */
public class T740 {
    class Solution {
        public int deleteAndEarn(int[] nums) {
            int max = 0;
            for (int item : nums) {
                max = Math.max(max, item);
            }
            int[] sum = new int[max + 1];
            for (int item : nums) {
                sum[item] += item;
            }
            return rob(sum);
        }

        public int rob(int[] nums) {
            int size = nums.length;
            int first = nums[0], second = Math.max(nums[0], nums[1]);
            for (int i = 2; i < size; i++) {
                int temp = second;
                second = Math.max(first + nums[i], second);
                first = temp;
            }
            return second;
        }
    }

    class Solution2 {
        public int deleteAndEarn(int[] nums) {
            int max = 0;
            for (int item : nums) {
                max = Math.max(max, item);
            }
            int[] sum = new int[max + 1];
            for (int item : nums) {
                sum[item] += item;
            }
            return rob(sum);
        }

        public int rob(int[] nums) {
            int size = nums.length;
            int[] dp = new int[size];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < size; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
            return dp[size - 1];
        }
    }
}
