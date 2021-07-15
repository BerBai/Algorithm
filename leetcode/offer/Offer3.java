package offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/15 09:53
 */
public class Offer3 {

    // 暴力循环
    public int findRepeatNumber1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    // set集合 哈希表
    public int findRepeatNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;
    }

    // 数组代替哈希表
    public int findRepeatNumber3(int[] nums) {
        int[] bucket = new int[nums.length];
        Arrays.fill(bucket, -1);
        for (int i = 0; i < nums.length; i++) {
            if (bucket[nums[i]] != -1) {
                return nums[i];
            }
            bucket[nums[i]] = 1;
        }
        return -1;
    }

    // 优化空间复杂度，相当于对于下标进行排序，若重复返回重复数据
    public int findRepeatNumber4(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
            }
        }
        return -1;
    }
}
