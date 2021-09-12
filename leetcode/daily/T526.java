package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/16 18:14
 */
public class T526 {
    class Solution {
        public int countArrangement(int n) {
            int[] f = new int[1 << n];
            f[0] = 1;
            for (int mask = 1; mask < (1 << n); mask++) {
                int num = Integer.bitCount(mask);
                for (int i = 0; i < n; i++) {
                    if ((mask & (1 << i)) != 0 && ((num % (i + 1)) == 0 || (i + 1) % num == 0)) {
                        f[mask] += f[mask ^ (1 << i)];
                    }
                }
            }
            return f[(1 << n) - 1];
        }
    }
}
