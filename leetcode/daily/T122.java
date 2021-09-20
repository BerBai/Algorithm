package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/20 13:32
 */
public class T122 {
    // 模拟
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int ans = 0, minPrice = prices[0];
            for (int i = 1; i < n; i++) {
                if (prices[i - 1] > prices[i]) {
                    minPrice = prices[i];
                } else if (i + 1 < n && prices[i] > prices[i + 1]) {
                    ans += (prices[i] - minPrice);
                } else if (i + 1 == n && prices[i] > minPrice) {
                    ans += prices[i] - minPrice;
                }
            }
            return ans;
        }
    }

    // 转换一下，其实就是 大减小
    class solution2 {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int ans = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    ans += prices[i] - prices[i - 1];
                }
            }
            return ans;
        }
    }
}
