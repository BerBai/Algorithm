package offer;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/20 09:33
 */
public class Offer14_2 {
    static class Solution {
        // 分成3 乘积最大
        public int cuttingRope(int n) {
            if (n < 4) {
                return n - 1;
            }
            long res = 1;
            while (n > 4) {
                res = (long) (res * 3 % (1e9 + 7));
                n -= 3;
            }
            return (int) (res * n % (1e9 + 7));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.cuttingRope(500));
    }
}
