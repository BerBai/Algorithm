package daily;

import java.util.Arrays;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/3 10:55
 */
public class T581 {
    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int[] arr = nums.clone();
            Arrays.sort(arr);
            int i = 0, j = nums.length - 1;
            while (i <= j && nums[i] == arr[i]) {
                i++;
            }
            while (i <= j && nums[j] == arr[j]) {
                j--;
            }
            return j - i + 1;
        }
    }
}
