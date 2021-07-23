package offer;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/23 09:47
 */
public class Offer18 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode deleteNode(ListNode head, int val) {
            if (head.val == val) {
                return head.next;
            }
            ListNode p = head.next, q = head;
            while (p != null && p.val != val) {
                q = p;
                p = p.next;
            }
            if (p != null) {
                q.next = p.next;
            }
            return head;
        }
    }
}
