package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/1 08:05
 */
public class T876 {
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
        public ListNode middleNode(ListNode head) {
            ListNode fast = head, slow = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            if (fast.next == null) {
                return slow;
            } else {
                return slow.next;
            }
        }
    }
}
