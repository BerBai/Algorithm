package offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/27 09:32
 */
public class Offer27 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 递归
    class Solution {
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            mirrorTree(root.left);
            mirrorTree(root.right);
            return root;
        }
    }

    // 辅助栈
    class Solutio2 {
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode p = root;
            LinkedList<TreeNode> stack = new LinkedList<TreeNode>() {{
                add(p);
            }};
            while (!stack.isEmpty()) {
                final TreeNode node = stack.pop();
                if (node.left != null) {
                    stack.add(node.left);
                }
                if (node.right != null) {
                    stack.add(node.right);
                }
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
            }
            return root;
        }
    }
}
