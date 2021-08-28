package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/28 15:12
 */
public class T1480 {
    class Solution {
        public int[] runningSum(int[] nums) {
            int n = nums.length;
            for (int i = 1; i < n; i++) {
                nums[i] = nums[i - 1] + nums[i];
            }
            return nums;
        }
    }
}
