package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/9 08:37
 */
public class T191 {
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int ans = 0;
            for (int i = 0; i < 32; i++) {
                if ((n & (1 << i)) != 0) {
                    ans++;
                }
            }
            return ans;
        }
    }
}
