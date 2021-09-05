package daily;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/5 16:18
 */
public class T542_1 {
    // BFS
    class Solution {
        int[][] dir = new int[][]{{1, 0}, {0, -1}, {0, 1}, {0, -1}};
        int n, m;

        public int[][] updateMatrix(int[][] mat) {
            n = mat.length;
            m = mat[0].length;
            Queue<int[]> queue = new LinkedList<>();
            int[][] dist = new int[n][m];
            int[][] seen = new int[n][m];
            // 将所有的0点加入队列
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (mat[i][j] == 0) {
                        queue.offer(new int[]{i, j});
                        seen[i][j] = 1;
                    }
                }
            }

            while (!queue.isEmpty()) {
                int[] cel = queue.poll();
                int x = cel[0], y = cel[1];
                for (int i = 0; i < 4; i++) {
                    int mx = x + dir[i][0], my = y + dir[i][1];
                    if (mx >= 0 && mx < n && my >= 0 && my < m && seen[mx][my] != 1) {
                        dist[mx][my] = dist[x][y] + 1;
                        queue.offer(new int[]{mx, my});
                        seen[mx][my] = 1;
                    }
                }
            }
            return dist;
        }
    }
}
