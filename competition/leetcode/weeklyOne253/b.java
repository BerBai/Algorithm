package leetcode.weeklyOne253;

import java.util.*;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/8 10:46
 */
public class b {
    static class Solution {
        public static int minStoneSum(int[] piles, int k) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() { //大顶堆
                @Override
                public int compare(Integer i1, Integer i2) {
                    return i2 - i1;
                }
            });
            for (int item : piles) {
                maxHeap.offer(item);
            }
            while (k-- > 0) {
                Integer poll = maxHeap.poll();
                poll = (poll + 1) / 2;
                maxHeap.offer(poll);
            }
            int ans = 0;
            while (!maxHeap.isEmpty()) {
                ans += maxHeap.poll();
            }
            return ans;
        }

        public static void main(String[] args) {
            System.out.println(minStoneSum(new int[]{7302, 6794, 8608, 5968, 9724, 5797, 5930, 7304, 2641, 6552}, 4));
        }
    }
}
