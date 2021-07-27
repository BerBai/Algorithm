package offer;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/26 21:11
 */
public class Offer26 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
        }

        boolean recur(TreeNode A, TreeNode B) {
            if (B == null) {
                return true;
            }
            if (A == null || A.val != B.val) {
                return false;
            }
            return recur(A.left, B.left) && recur(A.right, B.right);
        }
    }
}
