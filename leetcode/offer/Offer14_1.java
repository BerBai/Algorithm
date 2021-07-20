package offer;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/20 08:58
 */
public class Offer14_1 {
    static class Solution {
        public int cuttingRope(int n) {
            if (n == 2) {
                return 1;
            }
            int ans = 0;
            for (int i = 2; i < n; i++) {
                int tmp = 1;
                for (int j = 0; j < n / i; j++) {
                    tmp *= i;
                }
                if (n % i == 1 && n / i > 1) {
                    tmp /= i;
                    tmp *= (i + 1);
                } else if (n % i > 1 && n / i > 1) {
                    tmp *= (n % i);
                }
                ans = Math.max(ans, tmp);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.cuttingRope(10));
    }
}
