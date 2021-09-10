package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/10 15:58
 */
public class T190 {
    public class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int ans = 0;
            for (int i = 0; i < 32; i++) {
                if ((n & (1 << i)) != 0) {
                    ans = (ans << 1) + 1;
                } else {
                    ans = ans << 1;
                }
            }
            return ans;
        }
    }
}
