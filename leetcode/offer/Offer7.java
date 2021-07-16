package offer;

import java.util.Stack;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/16 11:07
 */
public class Offer7 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || preorder.length == 0) {
                return null;
            }
            // 用于存储父节点的栈
            Stack<TreeNode> stack = new Stack<>();
            // 初始化树、栈
            TreeNode head = new TreeNode(preorder[0]);
            stack.push(head);
            int index = 0;
            // 遍历结点
            for (int i = 1; i < preorder.length; i++) {
                TreeNode p = stack.peek();

                if (p.val != inorder[index]) {
                    p.left = new TreeNode(preorder[i]);
                    stack.push(p.left);
                } else {
                    while (!stack.isEmpty() && stack.peek().val == inorder[index]) {
                        p = stack.pop();
                        index++;
                    }
                    p.right = new TreeNode(preorder[i]);
                    stack.push(p.right);
                }
            }
            return head;
        }
    }
}
