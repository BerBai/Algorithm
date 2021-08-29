package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/28 15:44
 */
public class T977 {
    // 双指针
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n];
            for (int i = 0, j = n - 1, pos = n - 1; i <= j; ) {
                if (nums[i] * nums[i] > nums[j] * nums[j]) {
                    ans[pos] = nums[i] * nums[i];
                    i++;
                } else {
                    ans[pos] = nums[j] * nums[j];
                    j--;
                }
                pos--;
            }
            return ans;
        }
    }
}
