package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/28 15:35
 */
public class T35 {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0, right = nums.length - 1, mid, ans = 0;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (nums[mid] >= target) {
                    ans = mid;
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
}
