package daily;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/17 21:46
 */
public class T106 {
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
        Map<Integer, Integer> map = new HashMap<>();
        int[] post;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            post = postorder;
            TreeNode root = recursion(0, inorder.length - 1, 0, post.length - 1);
            return root;
        }

        public TreeNode recursion(int is, int ie, int ps, int pe) {
            if (ie < is || pe < ps) {
                return null;
            }

            int root = post[pe];
            int ri = map.get(root);

            TreeNode node = new TreeNode(root);
            node.left = recursion(is, ri - 1, ps, ps + ri - is - 1);
            node.right = recursion(ri + 1, ie, ps + ri - is, pe - 1);
            return node;
        }
    }
}
