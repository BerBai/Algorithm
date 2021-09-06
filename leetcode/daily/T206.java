package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/6 10:00
 */
public class T206 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode node = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return node;
        }
    }
}
