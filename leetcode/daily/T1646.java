package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/23 09:11
 */
public class T1646 {
    /**
     * nums[0] = 0
     * nums[1] = 1
     * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
     * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
     */
    class Solution {
        public int getMaximumGenerated(int n) {
            int max = 0;
            int[] nums = new int[n + 1];
            nums[0] = 0;
            if (n > 0) {
                nums[1] = 1;
                max = 1;
            }
            for (int i = 1; i <= n / 2; i++) {
                if (2 * i > n) {
                    break;
                }
                nums[2 * i] = nums[i];
                max = Math.max(nums[2 * i], max);
                if (2 * i + 1 > n) {
                    break;
                }
                nums[2 * i + 1] = nums[i] + nums[i + 1];
                max = Math.max(nums[2 * i + 1], max);
            }
            return max;
        }
    }
}
