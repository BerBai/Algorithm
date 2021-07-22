package offer;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/22 09:35
 */
public class Offer16 {
    // 指数可能的情况 负数 0 小数 正数
    class Solution {
        public double myPow(double x, int n) {
            long ntmp = n;
            if (x == 0.0) {
                return 0.0;
            }
            if (n < 0) {
                x = 1 / x;
                ntmp = -ntmp;
            }
            return dp(x, ntmp);
        }

        public double dp(double x, long n) {
            if (n == 0) {
                return 1;
            }
            if (n == 1) {
                return x;
            }
            double ans = dp(x, n >> 1);
            ans *= ans;
            if ((n & 0x1) == 1) {
                ans *= x;
            }
            return ans;
        }
    }
}
