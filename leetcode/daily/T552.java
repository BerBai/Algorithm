package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/18 09:08
 */
public class T552 {
    class Solution {
        int mod = (int) (1e9 + 7);

        public int checkRecord(int n) {
            if (n == 0) {
                return 0;
            } else if (n == 1) {
                return 3;
            }
            long[][] dp = new long[n + 1][3];
            dp[0][0] = dp[1][0] = dp[1][1] = 1;
            dp[1][2] = 0;
            for (int i = 2; i <= n; i++) {
                dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % mod;
                dp[i][1] = (dp[i - 1][0]) % mod;
                dp[i][2] = (dp[i - 1][1]) % mod;
            }
            long ans = 0;
            for (int i = 0; i < n; i++) {
                ans += (((dp[i][0] + dp[i][1] + dp[i][2]) % mod) * ((dp[n - i - 1][0] + dp[n - i - 1][1] + dp[n - i - 1][2]) % mod)) % mod;
            }
            return (int) ((ans + dp[n][0] + dp[n][1] + dp[n][2]) % mod);
        }
    }
}
