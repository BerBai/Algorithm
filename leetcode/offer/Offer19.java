package offer;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/23 10:08
 */
public class Offer19 {
    static class Solution {
        public static boolean isMatch(String s, String p) {
            if (s == null || p == null) {
                return false;
            }
            final char[] ptmp = p.toCharArray();
            final char[] stmp = s.toCharArray();
            return matchStr(stmp, ptmp, 0, 0);
        }

        public static boolean matchStr(char[] s, char[] p, int i, int j) {
            if (s.length - i == 0 && p.length - j == 0) {
                return true;
            }
            if (s.length - i != 0 && p.length - j == 0) {
                return false;
            }
            if (p.length - j != 1 && p[j + 1] == '*') {
                if (s.length - i != 0 && (p[j] == s[i] || (p[j] == '.' && s.length - i != 0))) {
                    return matchStr(s, p, i + 1, j + 2) || matchStr(s, p, i + 1, j) || matchStr(s, p, i, j + 2);
                } else {
                    return matchStr(s, p, i, j + 2);
                }
            }
            if (s.length - i != 0 && (s[i] == p[j] || (p[j] == '.' && s.length - i != 0))) {
                return matchStr(s, p, i + 1, j + 1);
            }
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.isMatch("aa", "a"));
        System.out.println(Solution.isMatch("aa", "a*"));
        System.out.println(Solution.isMatch("ab", ".*"));
        System.out.println(Solution.isMatch("aab", "c*a*b"));
        System.out.println(Solution.isMatch("mississippi", "mis*is*p*."));
        System.out.println(Solution.isMatch("ab", ".*c"));
    }
}
