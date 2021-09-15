package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/14 16:58
 */
public class T509 {
    // 动态规划
    class Solution {
        public int fib(int n) {
            if (n == 0) {
                return 0;
            } else if (n == 1) {
                return 1;
            }
            int a = 0, b = 1, c = 1;
            for (int i = 2; i <= n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
    }

    // 递归 记忆化搜索
    class Solution2 {
        public int fib(int n) {
            int[] dp = new int[n + 1];
            return dfs(n, dp);
        }

        public int dfs(int n, int[] dp) {
            if (n == 0) {
                return 0;
            } else if (n == 1) {
                return 1;
            }
            if (dp[n] != 0) {
                return dp[n];
            }
            return dp[n] = dfs(n - 1, dp) + dfs(n - 2, dp);
        }
    }
}
