package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/19 13:21
 */
public class T650 {
    // 1.
    class Solution {
        public int minSteps(int n) {
            int ans = 0;
            for (int i = 2; i < n; i++) {
                while (n % i == 0) {
                    ans += i;
                    n /= i;
                }
            }
            if (n > 0) {
                ans += n;
            }
            return ans;
        }
    }

    class Solution2 {

        int INF = 10000;

        public int minSteps(int n) {
            return dfs(n, 1, 0);
        }

        private int dfs(int n, int curr, int clipboard) {
            if (curr > n) {
                return INF;
            }
            if (curr == n) {
                return 0;
            }

            int ans = INF;
            if (clipboard > 0) {
                // 粘贴剪切板字符
                ans = Math.min(ans, dfs(n, curr + clipboard, clipboard));
            }

            // 简单剪枝，如果上一次是复制，这一次就没有必要再复制了
            if (curr != clipboard) {
                // 复制当前全部字符
                ans = Math.min(ans, dfs(n, curr, curr));
            }
            return ans + 1;
        }
    }
}
