package offer;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/24 08:54
 */
public class Offer20 {
    // [+|-]A[.B[e|E[+|-]C]]
    // [+|-].B[e|E[+|-]C]
    class Solution {
        public boolean isNumber(String s) {
            int n = s.length();
            int index = 0;
            boolean hasNum = false, hasE = false, hasSign = false, hasDot = false;
            while (index < n && s.charAt(index) == ' ') {
                index++;
            }
            while (index < n) {
                while (index < n && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                    index++;
                    hasNum = true;
                }
                if (index == n) {
                    break;
                }
                char c = s.charAt(index);
                if (c == 'e' || c == 'E') {
                    if (hasE || !hasNum) {
                        return false;
                    }
                    hasE = true;
                    hasNum = false;
                    hasSign = false;
                    hasDot = false;
                } else if (c == '+' || c == '-') {
                    if (hasSign || hasNum || hasDot) {
                        return false;
                    }
                    hasSign = true;
                } else if (c == '.') {
                    if (hasDot || hasE) {
                        return false;
                    }
                    hasDot = true;
                } else if (c == ' ') {
                    break;
                } else {
                    return false;
                }
                index++;
            }
            while (index < n && s.charAt(index) == ' ') {
                index++;
            }
            return hasNum && index == n;
        }
    }
}
