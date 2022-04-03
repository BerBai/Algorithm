package top100.preSum;

/**
 * @author ber
 * @version 1.0
 * @date 22/4/3 10:34
 */
public class T013 {

    /**
     * 题：https://leetcode-cn.com/problems/O4NDxx/
     */
    class NumMatrix {
        int[][] sum;

        /**
         * 计算一维前缀和
         *
         * @param matrix
         */
        public NumMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            // 多一位，下标0表示元素和为0
            sum = new int[m][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 1; j <= n; j++) {
                    sum[i][j] = sum[i][j - 1] + matrix[i][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int ans = 0;
            for (int i = row1; i <= row2; i++) {
                // 加1表示当前元素的前缀和
                ans += (sum[i][col2 + 1] - sum[i][col1]);
            }
            return ans;
        }
    }
}
