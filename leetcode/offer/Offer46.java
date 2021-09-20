package offer;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/20 13:56
 */
public class Offer46 {
    class Solution {
        public int translateNum(int num) {
            int ans = 0;
            String s = String.valueOf(num);
            int n = s.length();
            int a = 1, b = 1;
            for (int i = 2; i < n; i++) {
                String tmp = s.substring(i - 2, i);
                int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
                b = a;
                a = c;
            }
            return a;
        }
    }
}
