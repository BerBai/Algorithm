package daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/8 16:56
 */
public class T70 {
    class Solution {
        public int climbStairs(int n) {
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }

    // 动态规划 记忆化递归搜索
    class Solution2 {
        Map<Integer, Integer> dp = new HashMap<Integer, Integer>();

        public int climbStairs(int n) {
            if (n < 3) {
                dp.put(n, n);
                return n;
            }
            if (dp.containsKey(n)) {
                return dp.get(n);
            }
            dp.put(n, climbStairs(n - 1) + climbStairs(n - 2));
            return dp.get(n);
        }
    }
}
