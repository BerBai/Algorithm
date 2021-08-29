package daily;


/**
 * @author ber
 * @version 1.0
 * @date 21/8/29 08:45
 */
public class T189 {
    class Solution {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                ans[(i + k) % n] = nums[i];
            }
            System.arraycopy(ans, 0, nums, 0, n);
        }
    }

    class Solution2 {
        public void rotate(int[] nums, int k) {
            // 考虑旋转几周的情况
            k %= nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }

        public void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
                start++;
                end--;
            }
        }
    }
}
