package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/30 20:09
 */
public class T171 {
    class Solution {
        public int titleToNumber(String columnTitle) {
            if (columnTitle == null) {
                return 0;
            }
            int ans = columnTitle.charAt(columnTitle.length() - 1) - 'A' + 1, tmp = 26;

            for (int i = columnTitle.length() - 2; i >= 0; i--) {
                ans += ((columnTitle.charAt(i) - 'A' + 1) * tmp);
                tmp *= 26;
            }
            return ans;
        }
    }


}
