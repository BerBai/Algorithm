package offer;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/18 13:20
 */
public class Offer47 {

    class Solution2 {
        public int maxValue(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    if (i == 0) {
                        grid[i][j] += grid[i][j - 1];
                    } else if (j == 0) {
                        grid[i][j] += grid[i - 1][j];
                    } else {
                        grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
                    }
                }
            }
            return grid[m - 1][n - 1];
        }
    }
}
