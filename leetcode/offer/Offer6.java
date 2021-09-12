package offer;

import java.util.*;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/15 14:30
 */
public class Offer6 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 栈实现
    public int[] reversePrint1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = stack.pop().val;
        }
        return ans;
    }

    // 递归实现
    public int[] reversePrint2(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode p = head;
        dp(p, list);
        int[] ans = new int[list.size()];
        int i = 0;
        for (int num : list) {
            ans[i++] = num;
        }
        return ans;
    }

    private void dp(ListNode p, List list) {
        if (p == null) {
            return;
        }
        dp(p.next, list);
        list.add(p.val);
    }

    class Solution {
        public int[] reversePrint(ListNode head) {
            LinkedList<Integer> queue = new LinkedList<>();
            while (head != null) {
                queue.offerFirst(head.val);
                head = head.next;
            }
            int m = queue.size();
            int[] ans = new int[m];
            for (int i = 0; i < m; i++) {
                ans[i] = queue.removeFirst();
            }
            return ans;
        }
    }
}
