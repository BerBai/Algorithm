package offer;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/15 13:20
 */
public class Offer4 {
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        for (int[] i : matrix) {
            for (int j : i) {
                if (j == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // 从右上逐渐缩小范围
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix != null && matrix.length > 0 && matrix[0].length > 0) {
            for (int i = 0, j = matrix[0].length - 1; i < matrix.length && j >= 0; ) {
                if (matrix[i][j] == target) {
                    return true;
                } else if (matrix[i][j] > target) {
                    j--;
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    // 改用while循环
    public boolean findNumberIn2DArray3(int[][] matrix, int target) {
        if (matrix != null && matrix.length > 0 && matrix[0].length > 0) {
            int i = 0, j = matrix[0].length - 1;
            while (i < matrix.length && j >= 0) {
                if (matrix[i][j] == target) {
                    return true;
                } else if (matrix[i][j] > target) {
                    j--;
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    // 一样的思路，从左下角开始
    public boolean findNumberIn2DArray4(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }
}
