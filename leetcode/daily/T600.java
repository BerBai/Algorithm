package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/11 13:15
 */
public class T600 {
    class Solution {
        public int findIntegers(int n) {
            int[] dp = new int[32];
            dp[0] = dp[1] = 1;
            for (int i = 2; i < 31; ++i) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            int pre = 0, res = 0;
            for (int i = 29; i >= 0; --i) {
                int val = 1 << i;
                if ((n & val) != 0) {
                    res += dp[i + 1];
                    if (pre == 1) {
                        break;
                    }
                    pre = 1;
                } else {
                    pre = 0;
                }

                if (i == 0) {
                    ++res;
                }
            }

            return res;

        }
    }
}
