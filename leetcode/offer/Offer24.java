package offer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/25 10:37
 */
public class Offer24 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 迭代 遍历
    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode ans = null, p = head;
            while (p != null) {
                ListNode tmp = p.next;
                p.next = ans;
                ans = p;
                p = tmp;
            }
            return ans;
        }
    }

    // 递归 复杂不好理解，详见题解
    class Solution2 {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode newNode = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return newNode;
        }
    }
}
