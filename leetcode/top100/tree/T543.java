package top100.tree;

/**
 * @author ber
 * @version 1.0
 * @date 22/4/22 12:05
 */
public class T543 {
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

    class Solution {
        int ans = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            maxDeep(root);
            return ans;
        }

        private int maxDeep(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = maxDeep(root.left);
            int right = maxDeep(root.right);
            ans = Math.max(ans, left + right);
            return Math.max(left, right) + 1;
        }
    }

}
