package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/13 09:33
 */
public class T233 {
    class Solution {
        public int countDigitOne(int n) {
            long mulk = 1;
            int ans = 0;
            for (int i = 0; n >= mulk; i++) {
                ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
                mulk *= 10;
            }
            return ans;
        }
    }
}
