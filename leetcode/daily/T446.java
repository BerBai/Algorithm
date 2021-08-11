package daily;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/11 08:43
 */
public class T446 {
    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            int n = nums.length, ans = 0;
            // 坐标0不需要HashMap
            Map<Long, Integer>[] dp = new Map[n - 1];
            for (int i = 1; i < n; i++) {
                dp[i - 1] = new HashMap<>();
            }
            // 当前某些等差序列的末尾
            for (int i = 0; i < n - 1; i++) {
                // 当前想要加入的数，是否属于这个末尾的哪个等差序列?
                for (int j = i + 1; j < n; j++) {
                    long diff = 1L * nums[j] - nums[i];
                    // 当前以i为末尾,差为diff的等差序列的个数
                    int cnts = i > 0 ? dp[i - 1].getOrDefault(diff, 0) : 0;
                    // 前面i以diff为差的每个等差序列，均可以和j构成一个新的等差序列
                    ans += cnts;
                    // 以j为末尾，差为diff的新等差序列个数 (i -> j)
                    dp[j - 1].put(diff, dp[j - 1].getOrDefault(diff, 0) + cnts + 1);
                }
            }
            return ans;
        }
    }
}
