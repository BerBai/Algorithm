package daily;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/19 10:24
 */
public class T345 {
    class Solution {
        public String reverseVowels(String s) {
            Set set = new HashSet() {{
                add('a');
                add('e');
                add('i');
                add('o');
                add('u');
                add('A');
                add('E');
                add('I');
                add('O');
                add('U');
            }};
            final char[] ans = s.toCharArray();
            int n = s.length();
            int i = 0, j = n - 1;
            while (i < j) {
                if (!set.contains(ans[i])) {
                    i++;
                }
                if (!set.contains(ans[j])) {
                    j--;
                }
                if (set.contains(ans[i]) && set.contains(ans[j])) {
                    char tmp = ans[i];
                    ans[i] = ans[j];
                    ans[j] = tmp;
                    i++;
                    j--;
                }
            }
            return String.valueOf(ans);
        }
    }
}
