package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/30 10:59
 */
public class T283 {
    // 借助数组
    class Solution {
        public void moveZeroes(int[] nums) {
            int n = nums.length, j = 0;
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                if (nums[i] != 0) {
                    ans[j++] = nums[i];
                }
            }
            for (; j < n; j++) {
                ans[j] = 0;
            }
            System.arraycopy(ans, 0, nums, 0, n);
        }
    }

    // 快慢双指针
    class Solution2 {
        public void moveZeroes(int[] nums) {
            int n = nums.length, left = 0, right = 0;
            while (right < n) {
                if (nums[right] != 0) {
                    int tmp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = tmp;
                    left++;
                }
                right++;
            }
        }
    }
}
