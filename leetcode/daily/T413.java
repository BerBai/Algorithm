package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/10 15:57
 */
public class T413 {
    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            int n = nums.length, ans = 0;
            if (n == 1) {
                return ans;
            }
            int d = nums[0] - nums[1], t = 0;
            for (int i = 2; i < n; i++) {
                if (nums[i - 1] - nums[i] == d) {
                    ++t;
                } else {
                    d = nums[i - 1] - nums[i];
                    t = 0;
                }
                ans += t;
            }
            return ans;
        }
    }
}
