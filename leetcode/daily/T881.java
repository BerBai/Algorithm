package daily;

import java.util.Arrays;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/26 09:08
 */
public class T881 {
    /**
        贪心，从小到大排序，因只能乘坐两人，所以用最轻与最重的相加，如超过限制则单独一艘
     */
    class Solution {
        public int numRescueBoats(int[] people, int limit) {
            Arrays.sort(people);
            int ans = 0;
            int light = 0, heavy = people.length - 1;
            while (light <= heavy) {
                if (people[light] + people[heavy] <= limit) {
                    light++;
                }
                heavy--;
                ans++;
            }
            return ans;
        }
    }
}
