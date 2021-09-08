package daily;

import java.util.*;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/7 20:56
 */
public class T77 {
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> ans = new ArrayList<>();
            if (k <= 0 || n < k) {
                return ans;
            }
            Deque<Integer> path = new ArrayDeque<>();
            dfs(n, k, 1, path, ans);
            return ans;
        }

        public void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> ans) {
            if (path.size() == k) {
                ans.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i <= n; i++) {
                path.offer(i);
                dfs(n, k, i + 1, path, ans);
                path.removeLast();
            }
        }
    }
}
