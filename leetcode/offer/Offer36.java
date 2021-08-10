package offer;

import java.util.*;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/9 10:15
 */
public class Offer36 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    class Solution {
        Node pre, head;

        public Node treeToDoublyList(Node root) {
            if (root == null) {
                return null;
            }
            dfs(root);
            head.left = pre;
            pre.right = head;
            return head;

        }

        public void dfs(Node root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            if (pre != null) {
                pre.right = root;
            } else {
                head = root;
            }
            root.left = pre;
            pre = root;
            dfs(root.right);
        }

    }
}
