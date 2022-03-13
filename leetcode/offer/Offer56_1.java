package offer;

/**
 * @author ber
 * @version 1.0
 * @date 22/3/13 11:27
 */
public class Offer56_1 {
    class Solution {
        public int[] singleNumbers(int[] nums) {
            // 假设出现一次的数字为a, b
            // c ^ c = 0,  c ^ 0 = c
            // x = (n1 ^ n2 ^ ... ^ a ^ b) = (a ^ b)
            int x = 0;
            for(int n : nums) {
                x ^= n;
            }

            // 获取二进制最低位的1
            int flag = x & (-x);
            // a ^ b = x, a ^ x = b，由此分离开a、b
            int ans = 0;
            for(int n : nums) {
                // a、b某一个在flag为1位置一定也是1
                // 同时相同数异或也是0，c ^ c = 0, a ^ 0 = 0 或者 b ^ 0 = b
                // 遍历完最终保留下a 或者 b
                if((flag&n)==0) {
                    ans ^= n;
                }
            }
            return new int[]{ans, ans^x};
        }
    }
}
