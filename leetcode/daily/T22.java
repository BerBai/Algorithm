package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/2 08:26
 */
public class T22 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 双指针 前后相差K
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
