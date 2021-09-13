package offer;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/13 17:31
 */
public class Offer53_2 {
    class Solution {
        public int missingNumber(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if(i != nums[i]) {
                    return i;
                }
            }
            return n;
        }
    }
}
