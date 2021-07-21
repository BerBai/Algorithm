package offer;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/21 19:25
 */
public class Offer15 {
    // 负数的二进制首位是1，若采用 n>>1 最终会出现全1，从而进入死循环
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int ans = 0;
            int flag = 1;
            while (flag != 0) {
                if ((n & flag) == 1) {
                    ans++;
                }
                flag = flag << 1;
            }
            return ans;
        }
    }

    // (n-1)&n
    public class Solution2 {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int ans = 0;
            while (n != 0) {
                ans++;
                n = (n - 1) & n;
            }
            return ans;
        }
    }
}
