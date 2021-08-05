package daily;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/5 13:46
 */
public class T802 {
    class Solution {
        public List<Integer> eventualSafeNodes(int[][] graph) {
            // 有向图节点个数
            int n = graph.length;
            // 邻接表存储 记录反图（出度为入度）
            List<List<Integer>> newGraph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                newGraph.add(new ArrayList<Integer>());
            }
            // 记录反图中节点的入度
            int[] in = new int[n];

            // 构建反图
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < graph[i].length; j++) {
                    newGraph.get(graph[i][j]).add(i);
                }
                // 原数组记录的节点出度，在反图中就是入度
                in[i] = graph[i].length;
            }
            // 拓扑排序
            Queue<Integer> queue = new LinkedList<>();
            /**
             * 1.将入度为0的入队
             * 2.弹出首元素x，遍历与x的连接的节点y，y的入度减1
             * 3.判断y节点入度是否为0，是则入队
             * 4.循环2、3，直至队列为空
             */
            for (int i = 0; i < n; i++) {
                if (in[i] == 0) {
                    queue.add(i);
                }
            }
            while (!queue.isEmpty()) {
                final Integer currentNode = queue.poll();
                for (int node : newGraph.get(currentNode)) {
                    in[node]--;
                    if (in[node] == 0) {
                        queue.add(node);
                    }
                }
            }

            // 最终反图中入度为0的节点 为安全点
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if(in[i] == 0) {
                    ans.add(i);
                }
            }
            return ans;
        }
    }
}
