package offer;

import java.util.Arrays;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/18 10:23
 */
public class Offer10_2 {
    class Solution {
        public int numWays(int n) {
            int[] sum = new int[n + 1];
            Arrays.fill(sum, -1);
            return dp(n, sum);
        }

        public int dp(int n, int[] sum) {
            if (n == 0 || n == 1) {
                return 1;
            }
            if (sum[n] != -1) {
                return sum[n];
            }
            return sum[n] = (int) ((dp(n - 1, sum) + dp(n - 2, sum)) % (1e9 + 7));
        }
    }
}
