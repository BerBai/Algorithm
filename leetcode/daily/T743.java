package daily;

import java.util.*;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/2 08:28
 */
public class T743 {
    // 广度优先
    class Solution {
        int INTMAX = 0x3f3f3f3f;

        public int networkDelayTime(int[][] times, int n, int k) {
            // 建图
            Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
            for (int[] node : times) {
                if (!map.containsKey(node[0])) {
                    map.put(node[0], new HashMap<>());
                }
                map.get(node[0]).put(node[1], node[2]);
            }
            // 记录到达节点时间
            int[] time = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                time[i] = INTMAX;
            }
            // 开始节点到达时间为0
            time[k] = 0;
            // 队列 存放到达节点 到达时间
            Deque<int[]> deque = new ArrayDeque<>();
            deque.addLast(new int[]{k, 0});
            while (!deque.isEmpty()) {
                final int[] currentNode = deque.pollFirst();
                if (map.containsKey(currentNode[0])) {
                    for (int item : map.get(currentNode[0]).keySet()) {
                        final int timeTmp = map.get(currentNode[0]).get(item) + currentNode[1];
                        if (timeTmp < time[item]) {
                            time[item] = timeTmp;
                            deque.addLast(new int[]{item, timeTmp});
                        }
                    }
                }
            }

            int ans = -1;
            for (int i = 1; i <= n; i++) {
                ans = Math.max(ans, time[i]);
            }
            return INTMAX == ans ? -1 : ans;
        }
    }

    // Dijkstra 单源最短路算法
    class Solution2 {
        int INTMAX = 0x3f3f3f3f;

        public int networkDelayTime(int[][] times, int n, int k) {
            // 建图
            Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
            for (int[] node : times) {
                if (!map.containsKey(node[0])) {
                    map.put(node[0], new HashMap<>());
                }
                map.get(node[0]).put(node[1], node[2]);
            }
            // 到达点的时间
            int[] time = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                time[i] = INTMAX;
            }
            time[k] = 0;

            // 记录达到的节点
            Set<Integer> set = new HashSet();
            while (true) {
                int currentNode = -1, timeTmp = INTMAX;
                for (int i = 1; i <= n; i++) {
                    if (time[i] < timeTmp && !set.contains(i)) {
                        currentNode = i;
                        timeTmp = time[i];
                    }
                }
                if (currentNode == -1) {
                    break;
                }
                // 将最近的节点加入已查集合并更新
                set.add(currentNode);
                if (map.containsKey(currentNode)) {
                    for (int node : map.get(currentNode).keySet()) {
                        time[node] = Math.min(time[node], map.get(currentNode).get(node) + timeTmp);
                    }
                }
            }
            int ans = -1;
            for (int i = 1; i <= n; i++) {
                ans = Math.max(ans, time[i]);
            }
            return ans == INTMAX ? -1 : ans;
        }
    }
}
