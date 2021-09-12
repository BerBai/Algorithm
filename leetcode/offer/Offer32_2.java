package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/1 11:20
 */
public class Offer32_2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            LinkedList<TreeNode> tmp1 = new LinkedList<>();
            LinkedList<TreeNode> tmp2 = new LinkedList<>();
            List<List<Integer>> ans = new ArrayList<>();
            if (root != null) {
                tmp1.add(root);
            }
            while (!tmp1.isEmpty() || !tmp2.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                while (!tmp1.isEmpty()) {
                    TreeNode treeNode = tmp1.removeFirst();
                    list.add(treeNode.val);
                    if (treeNode.left != null) {
                        tmp2.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        tmp2.add(treeNode.right);
                    }
                }
                if (list.size() != 0) {
                    ans.add(list);
                }
                list = new ArrayList<>();
                while (!tmp2.isEmpty()) {
                    TreeNode treeNode = tmp2.removeFirst();
                    list.add(treeNode.val);
                    if (treeNode.left != null) {
                        tmp1.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        tmp1.add(treeNode.right);
                    }
                }
                if (list.size() != 0) {
                    ans.add(list);
                }
            }
            return ans;
        }
    }
}
