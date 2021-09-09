package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/9 08:29
 */
public class T231_2 {
    class Solution {
        public boolean isPowerOfTwo(int n) {
            return n > 0 && (n & (n - 1)) == 0;
        }
    }
}
