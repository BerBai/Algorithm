package offer;

/**
 * @author ber
 * @version 1.0
 * @date 22/3/9 11:00
 */
public class Offer55_2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(getHigh(root.left) - getHigh(root.right)) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }

    private int getHigh(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getHigh(root.left), getHigh(root.right)) + 1;
    }
}
