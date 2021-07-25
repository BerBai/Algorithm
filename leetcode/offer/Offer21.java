package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/25 09:18
 */
public class Offer21 {
    // 双向链表。结果不能直接转int[]
    class Solution {
        public int[] exchange(int[] nums) {
            int n = nums.length;
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if ((nums[i] & 1) == 1) {
                    list.addFirst(nums[i]);
                } else {
                    list.addLast(nums[i]);
                }
            }
            int[] ans = new int[n];
            int i = 0;
            for (Integer item : list) {
                ans[i++] = item;
            }
            return ans;
        }
    }

    // 辅助数组
    class Solution2 {
        public int[] exchange(int[] nums) {
            int n = nums.length, index = 0;
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                if ((nums[i] & 1) == 1) {
                    ans[index++] = nums[i];
                }
            }
            for (int i = 0; i < n; i++) {
                if ((nums[i] & 1) != 1) {
                    ans[index++] = nums[i];
                }
            }
            return ans;
        }
    }

    // 头尾双指针
    class Solution3 {
        public int[] exchange(int[] nums) {
            int i = 0, j = nums.length - 1;
            while (i < j) {
                while (i < j && (nums[i] & 1) == 1) {
                    i++;
                }
                while (i < j && (nums[j] & 1) != 1) {
                    j--;
                }
                if (i >= j) {
                    break;
                }
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
            return nums;
        }
    }

    // 快慢双指针
    class Solution4 {
        public int[] exchange(int[] nums) {
            int slow = 0, fast = 0;
            while (fast < nums.length) {
                if ((nums[fast] & 1) == 1) {
                    int tmp = nums[fast];
                    nums[fast] = nums[slow];
                    nums[slow] = tmp;
                    slow++;
                }
                fast++;
            }
            return nums;
        }
    }
}
