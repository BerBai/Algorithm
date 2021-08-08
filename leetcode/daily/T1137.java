package daily;

import java.util.Arrays;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/8 16:00
 */
public class T1137 {
    // 动态规划 数据记录
    class Solution {
        public int tribonacci(int n) {
            int[] nums = new int[n + 1];
            if (n <= 0) {
                return 0;
            } else if (n <= 2) {
                return 1;
            }
            nums[0] = 0;
            nums[1] = nums[2] = 1;
            nums[3] = 2;
            for (int i = 3; i <= n; i++) {
                nums[i] = nums[i - 1] + nums[i - 2] + nums[i - 3];
            }
            return nums[n];
        }
    }

    // 动态规划 变量记录 空间复杂度O(1)
    class Solution2 {
        public int tribonacci(int n) {
            if (n <= 0) {
                return 0;
            } else if (n <= 2) {
                return 1;
            }
            int a = 0, b = 1, c = 1;

            for (int i = 3; i <= n; i++) {
                int d = a + b + c;
                a = b;
                b = c;
                c = d;
            }
            return c;
        }
    }

    // 动态规划 递归实现
    class Solution3 {
        int[] nums = new int[38];

        public int tribonacci(int n) {
            if (n <= 0) {
                return 0;
            } else if (n <= 2) {
                return 1;
            }
            if (nums[n] != 0) {
                return nums[n];
            }
            return nums[n] = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        }
    }

    // 矩阵快速幂
    class Solution4 {
        int N = 3;

        int[][] mul(int[][] a, int[][] b) {
            int[][] c = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j] + a[i][2] * b[2][j];
                }
            }
            return c;
        }

        public int tribonacci(int n) {
            if (n <= 0) {
                return 0;
            } else if (n <= 2) {
                return 1;
            }
            int[][] ans = new int[][]{
                    {1, 0, 0},
                    {0, 1, 0},
                    {0, 0, 1}
            };
            int[][] mat = new int[][]{
                    {1, 1, 1},
                    {1, 0, 0},
                    {0, 1, 0}
            };
            int k = n - 2;
            while (k != 0) {
                if ((k & 1) != 0) {
                    ans = mul(ans, mat);
                }
                mat = mul(mat, mat);
                k >>= 1;
            }
            return ans[0][0] + ans[0][1];
        }
    }
}
