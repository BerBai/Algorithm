package top100.binarySearch;

/**
 * @author ber
 * @version 1.0
 * @date 22/3/31 12:20
 */
public class T006 {
    /**
     * 题：https://leetcode-cn.com/problems/kLl5u1/
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            // 线性查找 - O(n)
            // 1. 二分查找 - O(logn)
            // [i + 1, nums.length - 1] 区间二分查找 target - x
            int index = binarySearch(nums, i + 1, nums.length - 1, target - x);
            if (index != -1) {
                return new int[]{i, index};
            }
        }

        return new int[0];
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
