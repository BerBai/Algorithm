package offer;

/**
 * @author ber
 * @version 1.0
 * @date 22/3/13 11:27
 */
public class Offer56_2 {
    class Solution {
        public int singleNumber(int[] nums) {
            // 三位数不用用异或解决，a^a^a = a
            // 考虑二进制位数相加，最后除以3，不能整除的就是当前位为1
            int tmp[] = new int[32];
            for (int i = 0; i < nums.length; i++) {
                int bit = 1;
                for (int j = 31; j >= 0; j--) {
                    if ((nums[i] & bit) != 0) {
                        tmp[j]++;
                    }
                    bit = bit << 1;
                }
            }
            int ans = 0;
            for (int i = 0; i < 32; i++) {
                ans = ans << 1;
                ans += tmp[i] % 3;
            }
            return ans;
        }
    }
}
