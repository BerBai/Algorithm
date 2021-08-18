package leetcode.weeklyOne254;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/15 11:13
 */
public class c {
    class Solution {
        private long MOD = (long) (1e9 + 7);

        // 要想使乘积最小，就要使值分散在两端
        public int minNonZeroProduct(int p) {
            long max_num = (1L << p) - 1;

            long x = max_num - 1;
            long n = (1L << (p - 1)) - 1;

            long res = max_num % MOD * quick_mul(x, n) % MOD;
            return (int) res;
        }

        public long quick_mul(long x, long n) {
            x %= MOD;
            long res = 1L;
            while (n > 0) {
                if ((n & 1) != 0) {
                    res = (res * x) % MOD;
                }
                x = (x * x) % MOD;
                n >>= 1;
            }
            return res;
        }
    }
}
