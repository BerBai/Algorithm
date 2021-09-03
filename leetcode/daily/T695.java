package daily;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/3 14:20
 */
public class T695 {
    // DFS
    class Solution {
        int[][] dir = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        int n, m;

        public int maxAreaOfIsland(int[][] grid) {
            int ans = 0;
            n = grid.length;
            m = grid[0].length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    ans = Math.max(ans, dfs(grid, i, j));
                }
            }
            return ans;
        }

        public int dfs(int[][] grid, int x, int y) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
                return 0;
            }
            int ans = 1;
            // 每次访问过的点，记0,。避免再次访问
            grid[x][y] = 0;
            for (int i = 0; i < 4; i++) {
                int mx = x + dir[i][0], my = y + dir[i][1];
                ans += dfs(grid, mx, my);
            }
            return ans;
        }
    }

    // BFS
    class Solution2 {
        int[][] dir = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        int n, m;

        public int maxAreaOfIsland(int[][] grid) {
            int ans = 0;
            n = grid.length;
            m = grid[0].length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int sumNum = grid[i][j];
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        if (cell[0] < 0 || cell[0] >= n || cell[1] < 0 || cell[1] >= m || grid[cell[0]][cell[1]] == 0) {
                            continue;
                        }
                        sumNum++;
                        grid[cell[0]][cell[1]] = 0;
                        for (int k = 0; k < 4; k++) {
                            int mx = cell[0] + dir[k][0], my = cell[1] + dir[k][1];
                            queue.offer(new int[]{mx, my});
                        }
                    }
                    ans = Math.max(ans, sumNum);
                }
            }
            return ans;
        }
    }
}
