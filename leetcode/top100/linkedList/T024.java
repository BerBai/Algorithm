package top100.linkedList;

/**
 * @author ber
 * @version 1.0
 * @date 22/3/30 13:35
 */
public class T024 {
    /**
     * 题：https://leetcode-cn.com/problems/UHnkqh/
     * 翻转链表
     */
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

    // 递归实现
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ans = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return ans;
    }
}

