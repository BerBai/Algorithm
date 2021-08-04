package daily;

import java.util.Arrays;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/4 08:34
 */
public class T611 {
    class Solution {
        public int triangleNumber(int[] nums) {
            int n = nums.length, ans = 0;
            Arrays.sort(nums);
            for (int i = n - 1; i >= 2; i--) {
                int k = 0, j = i - 1;
                while (k < j) {
                    // 如果满足三角条件，则[k,j]范围内都满足
                    if (nums[k] + nums[j] > nums[i]) {
                        ans += j - k;
                        j--;
                    } else {
                        k++;
                    }
                }
            }
            return ans;
        }
    }
}
