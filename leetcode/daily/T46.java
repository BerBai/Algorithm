package daily;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/7 21:07
 */
public class T46 {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            Deque<Integer> path = new ArrayDeque<>();
            dfs(nums.length, 0, nums, path, ans);
            return ans;
        }

        public void dfs(int n, int begin, int[] nums, Deque<Integer> path, List<List<Integer>> ans) {
            if (path.size() == n) {
                ans.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < n; i++) {
                if (path.contains(nums[i])) {
                    continue;
                }
                path.offer(nums[i]);
                dfs(n, i + 1, nums, path, ans);
                path.removeLast();
            }
        }

    }
}
