package offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/17 19:44
 */
public class Offer37 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "[]";
            }
            StringBuilder res = new StringBuilder("[");
            Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
                add(root);
            }};
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node != null) {
                    res.append(node.val + ",");
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    res.append("null,");
                }
            }
            res.replace(res.length() - 1, res.length(), "]");
            return res.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals("[]")) {
                return null;
            }
            String[] vals = data.substring(1, data.length() - 1).split(",");
            TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
            Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
                add(root);
            }};
            int i = 1;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (!"null".equals(vals[i])) {
                    node.left = new TreeNode(Integer.parseInt(vals[i]));
                    queue.offer(node.left);
                }
                i++;
                if (!"null".equals(vals[i])) {
                    node.right = new TreeNode(Integer.parseInt(vals[i]));
                    queue.offer(node.right);
                }
                i++;
            }
            return root;
        }
    }
}
