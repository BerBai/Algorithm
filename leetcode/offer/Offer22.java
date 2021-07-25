package offer;

import java.util.List;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/25 09:58
 */
public class Offer22 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            ListNode ans = head, p = head;
            for (int i = 0; i < k; i++) {
                p = p.next;
            }
            while (p != null) {
                p = p.next;
                ans = ans.next;
            }
            return ans;
        }
    }
}
