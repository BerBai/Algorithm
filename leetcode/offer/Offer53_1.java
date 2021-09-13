package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/13 17:28
 */
public class Offer53_1 {
    class Solution {
        public int search(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : nums) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            return map.getOrDefault(target, 0);
        }
    }
}
