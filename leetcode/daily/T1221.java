package daily;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/7 20:16
 */
public class T1221 {
    class Solution {
        public int balancedStringSplit(String s) {
            int n = s.length();
            int a = 0, b = 0, ans = 0;
            char[] chars = s.toCharArray();
            for (int i = 0; i < n; i++) {
                if (chars[i] == 'R') {
                    a++;
                } else {
                    b++;
                }
                if (a == b) {
                    ans++;
                }
            }
            return ans;
        }
    }
}
