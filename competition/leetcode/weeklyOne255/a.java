package leetcode.weeklyOne255;

import java.util.Arrays;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/22 10:30
 */
public class a {
    class Solution {
        public int findGCD(int[] nums) {
            Arrays.sort(nums);
            int min = nums[0], max = nums[nums.length - 1];
            return gcd(min,max);
        }

        public int gcd(int m, int n) {
            if (n == 0) {
                return m;
            } else {
                return gcd(n, m % n);
            }
        }
    }
}
