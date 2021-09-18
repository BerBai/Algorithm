package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/17 09:16
 */
public class T55 {
    // 用数组记录可达点，可继续优化
    class Solution {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            // 可达点
            int[] dp = new int[n];
            dp[0] = 1;
            for (int i = 0; i < n; i++) {
                if (dp[i] > 0) {
                    for (int j = i + 1; j < n && j <= i + nums[i]; j++) {
                        dp[j]++;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if (dp[i] == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    // 贪心
    class Solution2 {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            int maxIndex = 0;
            for (int i = 0; i < n; i++) {
                // 对于可达的点进行下一跳
                if (maxIndex >= i) {
                    maxIndex = Math.max(maxIndex, i + nums[i]);
                    if (maxIndex >= n - 1) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
