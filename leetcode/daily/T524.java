package daily;

import java.util.List;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/14 15:58
 */
public class T524 {
    class Solution {
        public String findLongestWord(String s, List<String> dictionary) {
            String res = "";
            for (String t : dictionary) {
                int i = 0, j = 0;
                while (i < t.length() && j < s.length()) {
                    if (t.charAt(i) == s.charAt(j)) {
                        ++i;
                    }
                    ++j;
                }
                if (i == t.length()) {
                    if (t.length() > res.length() || (t.length() == res.length() && t.compareTo(res) < 0)) {
                        res = t;
                    }
                }
            }
            return res;
        }
    }
}
