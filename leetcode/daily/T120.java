package daily;

import java.util.List;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/8 18:27
 */
public class T120 {
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[][] dp = new int[n][n];
            dp[0][0] = triangle.get(0).get(0);
            for (int i = 1; i < n; i++) {
                dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
                for (int j = 1; j < i; j++) {
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                }
                dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
            }
            int ans = dp[n - 1][0];
            for (int i = 0; i < n; i++) {
                ans = Math.min(dp[n - 1][i], ans);
            }
            return ans;
        }
    }
}
