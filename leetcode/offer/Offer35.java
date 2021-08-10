package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/9 09:47
 */
public class Offer35 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            Map<Node, Node> map = new HashMap<>();
            //  复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
            Node current = head;
            while (current != null) {
                map.put(current, new Node(current.val));
                current = current.next;
            }
            // 建立next和random指向
            current = head;
            while (current != null) {
                map.get(current).next = map.get(current.next);
                map.get(current).random = map.get(current.random);
                current = current.next;
            }
            return map.get(head);
        }
    }
}
