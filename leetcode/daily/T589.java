package daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ber
 * @version 1.0
 * @date 22/3/10 11:20
 */
public class T589 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

    class Solution {
        List<Integer> ans = new ArrayList<>();

        public List<Integer> preorder(Node root) {
            if (root == null) {
                return ans;
            }
            ans.add(root.val);
            for (Node child : root.children) {
                preorder(child);
            }
            return ans;
        }
    }
}
