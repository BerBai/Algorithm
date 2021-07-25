package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/24 15:35
 */
public class T1736 {
    class Solution {
        public String maximumTime(String time) {
            char[] chars = time.toCharArray();
            if (chars[0] == '?' && (chars[1] < '4' || chars[1] == '?')) {
                chars[0] = '2';
            } else if (chars[0] == '?' && chars[1] >= '4') {
                chars[0] = '1';
            }
            if ((chars[0] == '0' || chars[0] == '1') && chars[1] == '?') {
                chars[1] = '9';
            }
            if (chars[0] == '2' && chars[1] == '?') {
                chars[1] = '3';
            }
            if (chars[3] == '?') {
                chars[3] = '5';
            }
            if (chars[4] == '?') {
                chars[4] = '9';
            }
            return new String(chars);
        }
    }
}
