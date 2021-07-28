package daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/28 11:31
 */
public class T863 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution2 {
        ArrayList<Integer> ans;
        HashMap<TreeNode, Integer> map;
        int k_;

        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            ans = new ArrayList<>();
            map = new HashMap<>();
            k_ = k;
            ArrayList<TreeNode> path = dfs1(root, target);
            for (int i = 0; i < path.size(); i++)
                map.put(path.get(i), i);
            dfs2(root, k);
            return ans;
        }

        public ArrayList<TreeNode> dfs1(TreeNode node, TreeNode target) {
            if (node == null)
                return null;
            if (node == target) {
                ArrayList<TreeNode> res = new ArrayList<>();
                res.add(node);
                return res;
            }
            ArrayList<TreeNode> left, right;
            left = dfs1(node.left, target);
            if (left != null) {
                left.add(node);
                return left;
            }
            right = dfs1(node.right, target);
            if (right != null) {
                right.add(node);
                return right;
            }
            return null;
        }

        public void dfs2(TreeNode node, int dis) {
            if (node == null)
                return;
            if (map.containsKey(node)) {
                dis = k_ - map.get(node);
            }
            if (dis < 0 && !(node.left != null && map.containsKey(node.left)) && !(node.right != null && map.containsKey(node.right)))
                return;
            if (dis == 0)
                ans.add(node.val);
            dfs2(node.left, --dis);
            dfs2(node.right, dis);
        }
    }
}
