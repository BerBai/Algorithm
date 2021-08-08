package leetcode.weeklyTwo58;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/7 22:14
 */
public class a {
    class Solution {
        public String makeFancyString(String s) {
            int n = s.length();
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i < 2) {
                    ans.append(s.charAt(i));
                } else {
                    if (s.charAt(i - 1) == s.charAt(i) && s.charAt(i - 2) == s.charAt(i)) {
                        continue;
                    } else {
                        ans.append(s.charAt(i));
                    }
                }
            }
            return ans.toString();
        }
    }
}
