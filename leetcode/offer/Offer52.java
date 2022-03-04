package offer;

import java.util.LinkedList;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/21 11:19
 */
public class Offer52 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            LinkedList<ListNode> list = new LinkedList<>();
            while (headA != null) {
                list.add(headA);
                headA = headA.next;
            }
            while (headB != null) {
                if (list.contains(headB)) {
                    return headB;
                }
                headB = headB.next;
            }
            return null;
        }
    }
}
