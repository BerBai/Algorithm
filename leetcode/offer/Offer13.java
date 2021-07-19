package offer;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/19 14:20
 */
public class Offer13 {
    class Solution {
        public int movingCount(int m, int n, int k) {
            boolean[][] visited = new boolean[m][n];
            return dfs(visited, 0, 0, k);
        }

        public int dfs(boolean[][] visited, int i, int j, int k) {
            int sum = 0, tmpi = i, tmpj = j;
            while (tmpi > 0 || tmpj > 0) {
                sum += (tmpi % 10);
                sum += (tmpj % 10);
                tmpi /= 10;
                tmpj /= 10;
            }
            if (i >= visited.length || j >= visited[0].length || sum > k || visited[i][j]) {
                return 0;
            }
            visited[i][j] = true;
            return 1 + dfs(visited, i + 1, j, k) + dfs(visited, i, j + 1, k);
        }
    }
}
