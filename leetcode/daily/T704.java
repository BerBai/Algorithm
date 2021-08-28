package daily;


import sun.security.util.ArrayUtil;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/28 15:17
 */
public class T704 {
    class Solution {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1, mid;
            while (left <= right) {
                mid = (left + right) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            }
            return -1;
        }
    }
}
