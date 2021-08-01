package offer;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/27 10:37
 */
public class Offer29 {
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return new int[0];
            }
            /**
             * 1. →↓←↑
             * 2. →↓←
             * 3. →↓
             * 4. →
             */
            int r = 0, x = matrix[0].length, c = 0, y = matrix.length, count = 0;
            int[] ans = new int[x * y];
            while (true) {
                // →
                for (int i = r; i < x; i++) {
                    ans[count++] = matrix[c][i];
                }
                if (++c >= y) {
                    break;
                }
                // ↓
                for (int i = c; i < y; i++) {
                    ans[count++] = matrix[i][x - 1];
                }
                if (--x <= r) {
                    break;
                }
                // ←
                for (int i = x - 1; i >= r; i--) {
                    ans[count++] = matrix[y - 1][i];
                }
                if (--y <= c) {
                    break;
                }
                // ↑
                for (int i = y - 1; i >= c; i--) {
                    ans[count++] = matrix[i][r];
                }
                if (++r >= x) {
                    break;
                }
            }
            return ans;
        }
    }
}
