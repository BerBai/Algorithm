package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/20 13:21
 */
public class T121 {
    // 两次遍历
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length, ans = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    int tmp = prices[j] - prices[i];
                    if (tmp > ans) {
                        ans = tmp;
                    }
                }
            }
            return ans;
        }
    }

    public class Solution2 {
        public int maxProfit(int prices[]) {
            int minPrice = Integer.MAX_VALUE;
            int ans = 0, n = prices.length;
            for (int i = 0; i < n; i++) {
                if (prices[i] < minPrice) {
                    minPrice = prices[i];
                } else if (prices[i] - minPrice > ans) {
                    ans = prices[i] - minPrice;
                }
            }
            return ans;
        }
    }
}
