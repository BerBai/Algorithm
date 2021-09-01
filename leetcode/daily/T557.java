package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/31 09:51
 */
public class T557 {
    class Solution {
        public String reverseWords(String s) {
            final char[] chars = s.toCharArray();
            int n = s.length(), left = 0;
            for (int i = 0; i < n; i++) {
                if (chars[i] == ' ') {
                    reverse(chars, left, i - 1);
                    left = i + 1;
                    continue;
                }
                if (i == n - 1) {
                    reverse(chars, left, i);
                }
            }
            return new String(chars);
        }

        public void reverse(char[] chars, int left, int right) {
            while (left < right) {
                char c = chars[left];
                chars[left] = chars[right];
                chars[right] = c;
                left++;
                right--;
            }
        }
    }
}
