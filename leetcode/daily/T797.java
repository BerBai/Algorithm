package daily;

import java.util.*;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/25 14:32
 */
public class T797 {
    class Solution {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Deque<Integer> stack = new ArrayDeque<Integer>();

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            stack.offerLast(0);
            dfs(graph, 0, graph.length - 1);
            return ans;
        }

        public void dfs(int[][] graph, int x, int n) {
            if (x == n) {
                ans.add(new ArrayList<Integer>(stack));
                return;
            }
            for (int y : graph[x]) {
                stack.offerLast(y);
                dfs(graph, y, n);
                stack.pollLast();
            }
        }
    }
}
