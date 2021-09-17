package offer;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/17 08:29
 */
public class Offer63 {
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int ans = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (prices[j] - prices[i] > ans) {
                        ans = prices[j] - prices[i];
                    }
                }
            }
            return ans;
        }
    }
}
