package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/31 09:46
 */
public class T344 {
    class Solution {
        public void reverseString(char[] s) {
            int left = 0, right = s.length - 1;
            while (left < right) {
                final char c = s[left];
                s[left] = s[right];
                s[right] = c;
                left++;
                right--;
            }
        }
    }
}
