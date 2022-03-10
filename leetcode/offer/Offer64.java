package offer;

/**
 * @author ber
 * @version 1.0
 * @date 22/3/10 15:27
 */
public class Offer64 {
    // 不能使用for if。
    // 方式一：利用逻辑运算符的短路性质，&&前条件不满足就不执行后面的语句
    // 方式二：利用位运算计算求和公式
    class Solution {
        public int sumNums(int n) {
            boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
            return n;
        }

        public int sumNums_2(int n) {
            int ans = 0, A = n, B = n + 1;
            boolean flag;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            return ans >> 1;
        }
    }
}
