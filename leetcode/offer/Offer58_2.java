package offer;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/12 12:14
 */
public class Offer58_2 {
    class Solution {
        public String reverseLeftWords(String s, int n) {
            StringBuilder ans = new StringBuilder();
            n = n % s.length();
            char[] chars = s.toCharArray();
            for (int i = n; i < s.length(); i++) {
                ans.append(chars[i]);
            }
            for (int i = 0; i < n; i++) {
                ans.append(chars[i]);
            }
            return ans.toString();
        }
    }
}
