package daily;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/4 20:37
 */
public class T617 {
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
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null) {
                return t2;
            }
            if (t2 == null) {
                return t1;
            }
            TreeNode merged = new TreeNode(t1.val + t2.val);
            merged.left = mergeTrees(t1.left, t2.left);
            merged.right = mergeTrees(t1.right, t2.right);
            return merged;
        }
    }
}
