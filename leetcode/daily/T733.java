package daily;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/3 13:18
 */
public class T733 {
    // BFS
    class Solution {
        // 上下右左
        int[][] dir = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int current = image[sr][sc];
            if (current == newColor) {
                return image;
            }
            int n = image.length, m = image[0].length;

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{sr, sc});
            image[sr][sc] = newColor;
            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int mx = cell[0] + dir[i][0], my = cell[1] + dir[i][1];
                    if (mx >= 0 && mx < n && my >= 0 && my < m && image[mx][my] == current) {
                        queue.offer(new int[]{mx, my});
                        image[mx][my] = newColor;
                    }
                }
            }
            return image;
        }
    }

    // DFS
    class Solution2 {
        // 上下右左
        int[][] dir = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        int n, m;

        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int current = image[sr][sc];
            n = image.length;
            m = image[0].length;
            if (current != newColor) {
                dfs(image, sr, sc, current, newColor);
            }

            return image;
        }

        public void dfs(int[][] image, int x, int y, int color, int newColor) {
            if (image[x][y] == color) {
                image[x][y] = newColor;
                for (int i = 0; i < 4; i++) {
                    int mx = x + dir[i][0], my = y + dir[i][1];
                    if (mx >= 0 && mx < n && my >= 0 && my < m) {
                        dfs(image, mx, my, color, newColor);
                    }
                }
            }
        }
    }
}
