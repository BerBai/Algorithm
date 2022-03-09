package offer;

/**
 * @author ber
 * @version 1.0
 * @date 22/3/9 10:59
 */
public class Offer55_1 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.right) + 1, maxDepth(root.left) + 1);
    }
}
