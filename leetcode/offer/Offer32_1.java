package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/1 11:00
 */
public class Offer32_1 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {

        public int[] levelOrder(TreeNode root) {
            LinkedList<TreeNode> tmp = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            if (root != null) {
                tmp.add(root);
            }
            while (!tmp.isEmpty()) {
                list.add(tmp.getFirst().val);
                final TreeNode treeNode = tmp.removeFirst();
                if (treeNode.left != null) {
                    tmp.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    tmp.add(treeNode.right);
                }
            }
            int[] ans = new int[list.size()];
            int i = 0;
            for (int item : list) {
                ans[i++] = item;
            }
            return ans;
        }
    }
}
