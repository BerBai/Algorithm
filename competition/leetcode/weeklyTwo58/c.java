package leetcode.weeklyTwo58;

import java.util.Arrays;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/7 22:14
 */
public class c {
    class Solution {
        int INF = 0x3f3f3f3f;
        int n, sum;
        int[][] premax;

        public int minSpaceWastedKResizing(int[] nums, int k) {
            n = nums.length;
            sum = 0;
            int[][] premax = new int[n][n];
            for (int i = 0; i < n; i++) {
                int m = 0;
                for (int j = i; j < n; j++) {
                    m = Math.max(m, nums[j]);
                    premax[i][j] = m * (j + 1 - i);
                }
                sum += nums[i];
            }

            int[][] dp = new int[n][k + 2];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], INF);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= k + 1; j++) {
                    for (int l = 0; l <= i; l++) {
                        dp[i][j] = Math.min(dp[i][j], (l == 0 ? 0 : dp[l - 1][j - 1]) + premax[l][i]);
                    }
                }
            }
            return dp[n - 1][k + 1] - sum;
        }
    }
}
