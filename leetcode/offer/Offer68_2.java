package offer;

/**
 * @author ber
 * @version 1.0
 * @date 22/3/10 15:27
 */
public class Offer68_2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root.val == p.val || root.val == q.val)
                return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left == null) return right;
            if (right == null) return left;
            return root;
        }
    }
}
