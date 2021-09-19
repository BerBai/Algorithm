package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/18 11:22
 */
public class T918 {
    // 1：最大数组和在中间，和平时一样解法
    // 2：最大数组和是跨越头尾，回头了， 麻烦第二种，从两边出发往中间靠拢必须都是最大，那就说明中间段就是最小，找最小，再总和减去最小即可。
    // 3: 对比两者大小，取较大值答案
    class Solution {
        public int maxSubarraySumCircular(int[] nums) {
            int dp = nums[0], max = dp, sum = dp, min = 0;
            for (int i = 1; i < nums.length; i++) {
                sum += nums[i];
                dp = nums[i] + Math.max(dp, 0);
                max = Math.max(dp, max);
            }
            dp = nums[0];
            for (int i = 1; i < nums.length - 1; i++) {
                dp = nums[i] + Math.min(0, dp);
                min = Math.min(dp, min);
            }
            return Math.max(sum - min, max);
        }
    }
}
