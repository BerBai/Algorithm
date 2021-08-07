package daily;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/6 08:36
 */
public class T847 {
    class Solution {
        public int shortestPathLength(int[][] graph) {
            int n = graph.length;
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[n][1 << n];
            for (int i = 0; i < n; i++) {
                queue.add(new int[]{i, 1 << i, 0});
                visited[i][1 << i] = true;
            }
            int ans = 0;
            while (!queue.isEmpty()) {
                final int[] tuple = queue.poll();
                int u = tuple[0], mask = tuple[1], dist = tuple[2];
                if (mask == (1 << n) - 1) {
                    ans = dist;
                    break;
                }
                //搜索相邻的节点
                for (int v : graph[u]) {
                    // 将 mask 的 v 位置设为1
                    int maskV = mask | (1 << v);
                    if (!visited[v][maskV]) {
                        queue.add(new int[]{v, maskV, dist + 1});
                        visited[v][maskV] = true;
                    }
                }
            }
            return ans;
        }
    }
}
