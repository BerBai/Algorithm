package top100.dynamicProgramming;

/**
 * @author ber
 * @version 1.0
 * @date 22/3/31 12:16
 */
public class T003 {
    /**
     * 题：https://leetcode-cn.com/problems/w3tCBm/
     * 统计0到n之间数的二进制1的个数
     *
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }
}
