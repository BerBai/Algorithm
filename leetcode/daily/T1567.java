package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/20 13:17
 */
public class T1567 {
    class Solution {
        public int getMaxLen(int[] nums) {
            int length = nums.length;
            int[] positive = new int[length];
            int[] negative = new int[length];
            if (nums[0] > 0) {
                positive[0] = 1;
            } else if (nums[0] < 0) {
                negative[0] = 1;
            }
            int maxLength = positive[0];
            for (int i = 1; i < length; i++) {
                if (nums[i] > 0) {
                    positive[i] = positive[i - 1] + 1;
                    negative[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
                } else if (nums[i] < 0) {
                    positive[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
                    negative[i] = positive[i - 1] + 1;
                } else {
                    positive[i] = 0;
                    negative[i] = 0;
                }
                maxLength = Math.max(maxLength, positive[i]);
            }
            return maxLength;
        }
    }
}
