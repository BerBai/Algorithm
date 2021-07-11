import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/10 23:15
 */
public class BFS {

    public int[][] bfs(int[][] mat) {
        //存四个方法
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m = mat.length, n = mat[0].length;
        //存结果 根据题目要求
        int[][] dist = new int[m][n];

        //所有0节点入队
        boolean[][] visit = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //根据题目将相关位置或者点存入队列
            }
        }
        //广度遍历更新dist
        int count = 0; //根据题目要求是否定义
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] now = queue.poll();
                int i = now[0], j = now[1];
                for (int k = 0; k < 4; k++) {
                    //遍历四个方向
                    int i_new = i + dir[k][0];
                    int j_new = j + dir[k][1];
                    //先判断当前新位置是否符合边界条件
                    if (i_new >= 0 && i_new < m && j_new >= 0 && j_new < n && visit[i_new][j_new] != true) {
                        // 记录点
                        visit[i_new][j_new] = true;
                        queue.add(new int[]{i_new,j_new});
                        //相关处理
                    }
                }
            }
            //可以加一个判断次数的 count变量之类的
        }
        //return count;// 根据题目看返回是【count-最少步数】还是【dist-最短路径】
        return dist;
    }

}
