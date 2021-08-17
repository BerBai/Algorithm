package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/17 08:13
 */
public class T551 {
    class Solution {
        public boolean checkRecord(String s) {
            return s.indexOf("A") == s.lastIndexOf("A") && !s.contains("LLL");
        }
    }

    class Solution2 {
        public boolean checkRecord(String s) {
            int absents = 0, lates = 0;
            int n = s.length();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c == 'A') {
                    absents++;
                    if (absents >= 2) {
                        return false;
                    }
                }
                if (c == 'L') {
                    lates++;
                    if (lates >= 3) {
                        return false;
                    }
                } else {
                    lates = 0;
                }
            }
            return true;
        }
    }
}
