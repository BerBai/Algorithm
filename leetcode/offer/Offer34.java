package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/4 09:04
 */
public class Offer34 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 回溯法
    class Solution {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();

        public List<List<Integer>> pathSum(TreeNode root, int target) {
            recur(root, target);
            return ans;
        }

        void recur(TreeNode root, int tar) {
            if (root == null) {
                return;
            }
            tar -= root.val;
            path.add(root.val);
            if (tar == 0 && root.left == null && root.right == null) {
                ans.add(new LinkedList<>(path));
            }
            recur(root.left, tar);
            recur(root.right, tar);
            path.removeLast();
        }
    }
}
