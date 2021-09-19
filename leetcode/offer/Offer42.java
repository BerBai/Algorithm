package offer;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/18 13:15
 */
public class Offer42 {
    class Solution {
        public int maxSubArray(int[] nums) {
            int maxSum = 0, pre = nums[0];
            for (int num : nums) {
                pre = Math.max(pre + num, num);
                maxSum = Math.max(maxSum, pre);
            }
            return maxSum;
        }
    }
}
