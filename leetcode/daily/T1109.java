package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/31 09:44
 */
public class T1109 {
    class Solution {
        public int[] corpFlightBookings(int[][] bookings, int n) {
            int[] nums = new int[n];
            for (int[] booking : bookings) {
                nums[booking[0] - 1] += booking[2];
                if (booking[1] < n) {
                    nums[booking[1]] -= booking[2];
                }
            }
            for (int i = 1; i < n; i++) {
                nums[i] += nums[i - 1];
            }
            return nums;
        }
    }
}
