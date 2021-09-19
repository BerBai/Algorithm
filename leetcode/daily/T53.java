package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/18 10:58
 */
public class T53 {
    // 遍历模拟，会超出题目内存限制
    class Solution {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            int[][] dp = new int[n][n];
            dp[0][0] = nums[0];
            int maxNum = nums[0];
            for (int i = 1; i < n; i++) {
                dp[0][i] = dp[0][i - 1] + nums[i];
                maxNum = Math.max(dp[0][i], maxNum);
                for (int j = i; j < n; j++) {
                    if (j == i) {
                        dp[i][j] = nums[j];
                    } else {
                        dp[i][j] = dp[i][j - 1] + nums[j];
                    }
                    maxNum = Math.max(dp[i][j], maxNum);
                }
            }
            return maxNum;
        }
    }

    class Solution2 {
        public int maxSubArray(int[] nums) {
            int max = nums[0], sum = 0, n = nums.length;
            for (int i = 0; i < n; i++) {
                // 如果计数小于0，则重新开始计数
                if (sum > 0) {
                    sum += nums[i];
                } else {
                    sum = nums[i];
                }
                max = Math.max(sum, max);
            }
            return max;
        }
    }

    class Solution3 {
        public int maxSubArray(int[] nums) {
            int pre = 0, maxAns = nums[0];
            for (int x : nums) {
                // 如果计数比x小，重新开始计数
                pre = Math.max(pre + x, x);
                maxAns = Math.max(maxAns, pre);
            }
            return maxAns;
        }
    }
}
