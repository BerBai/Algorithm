package offer;

/**
 * @author ber
 * @version 1.0
 * @date 22/3/12 16:24
 */
public class Offer65 {
    // 位运算计算加法 博客：https://blog.csdn.net/Ber_Bai/article/details/123445743
    class Solution {
        public int add(int a, int b) {
            int sum = (a ^ b); // 和（未进位）
            int carry = ((a & b) << 1); // 进位
            while(carry!=0) {
                a = sum; b = carry;
                sum = (a ^ b);
                carry = ((a & b) << 1);
            }
            return sum;
        }
    }
}
