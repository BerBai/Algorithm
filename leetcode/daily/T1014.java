package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/20 13:18
 */
public class T1014 {
    class Solution {
        public int maxScoreSightseeingPair(int[] values) {
            int ans = 0, mx = values[0] + 0;
            for (int j = 1; j < values.length; ++j) {
                ans = Math.max(ans, mx + values[j] - j);
                // 边遍历边维护
                mx = Math.max(mx, values[j] + j);
            }
            return ans;
        }
    }
}
