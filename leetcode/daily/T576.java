package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/15 09:51
 */
public class T576 {
    class Solution {
        int mod = (int) 1e9 + 7;
        int dir[][] = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int mt, nt;
        int dp[][][];

        public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
            nt = n;
            mt = m;
            dp = new int[maxMove][m][n];
            return dfs(maxMove, startRow, startColumn);
        }

        public int dfs(int move, int r, int c) {
            if (r < 0 || r == mt || c < 0 || c == nt) {
                return 1;
            }
            if (move == 0 || (mt - move > r && r > move - 1 && nt - move > c && c > move - 1)) {
                return 0;
            }
            if (dp[--move][r][c] == 0) {
                for (int i = 0; i < 4; i++) {
                    int dx = dir[i][0], dy = dir[i][1];
                    dp[move][r][c] = (dp[move][r][c] + dfs(move, r + dx, c + dy)) % mod;
                }
            }
            return dp[move][r][c];
        }
    }
}
