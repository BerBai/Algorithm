package top100.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ber
 * @version 1.0
 * @date 22/3/26 11:57
 */
public class T001 {
    /**
     * 题：https://leetcode-cn.com/problems/two-sum/
     *
     * @param nums   无序的整型数组，2<=n<10000 -10^9 <= nums[i] <= 10^9
     * @param target -109 <= target <= 109
     * @return
     */


    public int[] twoSum(int[] nums, int target) {
        // 建立hashmap记录数组下标与元素
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 循环查找数组中两数之和等于target
        for (int i = 0; i < nums.length; i++) {
            // 如果两数和符合条件，解得答案
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
