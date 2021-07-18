package offer;

import java.util.Arrays;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/18 09:59
 */
public class Offer10 {
    class Solution {
        // timeout
        public int fib1(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            return (int) (fib1(n - 1) + fib1(n - 2) % (1e9 + 7));
        }

        // 采用记忆化搜索优化
        public int fib2(int n) {
            int[] sum = new int[1005];
            Arrays.fill(sum, -1);
            return dp(n, sum);
        }
        public int dp(int n, int[] sum) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            if (sum[n] != -1) {
                return sum[n];
            }
            return sum[n] = (int) ((dp(n - 1, sum) + dp(n - 2, sum)) % (1e9 + 7));
        }
    }
}
