package daily;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/4 21:00
 */
public class T116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


    class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return root;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int n = queue.size();
                for (int i = 0; i < n; i++) {
                    Node node = queue.poll();
                    if (i < n - 1) {
                        node.next = queue.peek();
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            return root;
        }
    }
}
