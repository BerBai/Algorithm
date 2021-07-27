package offer;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/27 09:51
 */
public class Offer28 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return compare(root.left, root.right);
        }

        public boolean compare(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            return compare(left.left, right.right) && compare(left.right, right.left);
        }
    }
}
