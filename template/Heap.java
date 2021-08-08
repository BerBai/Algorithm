import java.util.*;

/**
 * 小顶堆和大顶堆的实现
 *
 * @author ber
 * @version 1.0
 * @date 21/8/8 15:40
 */
public class Heap {

    // 小顶堆
    public PriorityQueue<Integer> minHeap(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for (int num : nums) {
            minHeap.offer(num);
        }
        return minHeap;
    }

    //大顶堆,长度nums.length
    public PriorityQueue<Integer> maxHeap(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(nums.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
        for (int num : nums) {
            maxHeap.offer(num);
        }
        return maxHeap;
    }
}
