package daily;

import java.util.*;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/9 08:30
 */
public class T313 {
    class Solution {
        public int nthSuperUglyNumber(int n, int[] primes) {
            PriorityQueue<Long> minHeap = new PriorityQueue<>();
            Set<Long> set = new HashSet<>();
            set.add(1L);
            minHeap.offer(1L);
            int ans = 0;
            for (int i = 0; i < n; i++) {
                long current = minHeap.poll();
                ans = (int) current;
                for (int prime : primes) {
                    long next = prime * current;
                    if (set.add(next)) {
                        minHeap.offer(next);
                    }
                }
            }
            return ans;
        }
    }
}
