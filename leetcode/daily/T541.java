package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/20 11:41
 */
public class T541 {
    class Solution {
        public String reverseStr(String s, int k) {
            char[] chars = s.toCharArray();
            int i, j, q, n = s.length();
            for (i = 0; i < n; i++) {
                j = i + k - 1;
                if (j >= n) {
                    j = n - 1;
                }
                q = j;
                while (i < j) {
                    char tmp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = tmp;
                    i++;
                    j--;
                }
                i = q + k;
            }
            return String.valueOf(chars);
        }
    }
}
