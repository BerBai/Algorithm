package leetcode.weeklyTwo56;

import java.util.*;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/11 14:24
 */
public class b {
    public static int nearestExit(char[][] maze, int[] entrance) {
        // 四个方向
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // 地图范围
        int m = maze.length, n = maze[0].length;
        // 存位置
        Queue<int[]> queue = new LinkedList<>();

        // 开始位置入队
        queue.add(entrance);
        // 判断访问
        boolean[][] visited = new boolean[m][n];
        // 起点初始化
        visited[entrance[0]][entrance[1]] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            // 记录队列位置个数
            int size = queue.size();
            // 记录到之指定位置的距离
            count++;

            while (size-- > 0) {
                int[] nowPos = queue.poll();
                int i = nowPos[0], j = nowPos[1];
                // 走四个方向
                for (int k = 0; k < 4; k++) {
                    int i_new = i + dir[k][0];
                    int j_new = j + dir[k][1];

                    // 边界条件、剪枝
                    if (i_new >= 0 && i_new < m && j_new >= 0 && j_new < n && maze[i_new][j_new] == '.' && visited[i_new][j_new] != true) {
                        // 最先到达出口位置，即最短路
                        if (i_new == 0 || i_new == m - 1 || j_new == 0 || j_new == n - 1) {
                            return count;
                        }
                        visited[i_new][j_new] = true;
                        queue.add(new int[]{i_new, j_new});
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        char[][] maze = new char[][]{{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}};
        int[] entrance = new int[]{1,2};
        System.out.println(b.nearestExit(maze, entrance));
    }
}
