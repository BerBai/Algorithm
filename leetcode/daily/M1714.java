package daily;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/3 13:12
 */
public class M1714 {
    // 排序
    class Solution {
        public int[] smallestK(int[] arr, int k) {
            Arrays.sort(arr);
            int[] ans = new int[k];
            for (int i = 0; i < k; i++) {
                ans[i] = arr[i];
            }
            return ans;
        }
    }

    //    堆
    class Solution2 {
        public int[] smallestK(int[] arr, int k) {
            int[] vec = new int[k];
            if (k == 0) { // 排除 0 的情况
                return vec;
            }
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer num1, Integer num2) {
                    return num2 - num1;
                }
            });
            for (int i = 0; i < k; ++i) {
                queue.offer(arr[i]);
            }
            for (int i = k; i < arr.length; ++i) {
                if (queue.peek() > arr[i]) {
                    queue.poll();
                    queue.offer(arr[i]);
                }
            }
            for (int i = 0; i < k; ++i) {
                vec[i] = queue.poll();
            }
            return vec;
        }
    }
}
