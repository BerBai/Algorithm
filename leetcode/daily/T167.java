package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/30 11:11
 */
public class T167 {
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0, right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    break;
                }
            }
            return new int[]{left + 1, right + 1};
        }
    }
}
