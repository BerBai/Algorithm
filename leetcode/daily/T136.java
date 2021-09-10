package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/10 16:18
 */
public class T136 {
    class Solution {
        public int singleNumber(int[] nums) {
            int ans = 0;
            for (int num : nums) {
                ans = ans ^ num;
            }
            return ans;
        }
    }
}
