package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/20 11:02
 */
public class T673 {
    class Solution {
        public int findNumberOfLIS(int[] nums) {
            int n = nums.length, maxLen = 0, ans = 0;
            int[] dp = new int[n];
            int[] cnt = new int[n];
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
                cnt[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        if (dp[i] < dp[j] + 1) {
                            dp[i] = dp[j] + 1;
                            cnt[i] = cnt[j];
                        } else if (dp[j] + 1 == dp[i]) {
                            cnt[i] += cnt[j];
                        }
                    }
                }
                // 最长递增序列
                if (maxLen < dp[i]) {
                    maxLen = dp[i];
                    ans = cnt[i];
                } else if (maxLen == dp[i]) {
                    ans += cnt[i];
                }
            }
            return ans;
        }
    }
}
