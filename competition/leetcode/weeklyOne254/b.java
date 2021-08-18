package leetcode.weeklyOne254;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/15 10:42
 */
public class b {
    static class Solution {
        public static int[] rearrangeArray(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n];
            for (int i = 1; i < n - 1; i++) {
                if ((nums[i - 1] + nums[i + 1]) / 2 == nums[i]) {
                    int k = i + 2;
                    while (k < n && ((nums[i - 1] + nums[i + 1]) / 2 == nums[k] || (i > 2 && (nums[i - 2] + nums[k]) / 2 == nums[i - 1]))) {
                        k++;
                    }
                    int tmp = nums[i + 1];
                    if (k < n) {
                        nums[i] = nums[k];
                        nums[k] = tmp;
                    } else {
                        nums[i] = nums[i + 1];
                        nums[i + 1] = tmp;
                    }

                }
            }
            return nums;
        }

        public static void main(String[] args) {
            System.out.println(rearrangeArray(new int[]{1, 2, 3}));
        }
    }
}
