package daily;

import java.util.Arrays;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/26 10:19
 */
public class T300 {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int maxNum = 1;
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                maxNum = Math.max(maxNum, dp[i]);
            }
            return maxNum;
        }
    }
}
