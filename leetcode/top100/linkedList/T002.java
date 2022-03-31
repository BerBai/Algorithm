package top100.linkedList;

/**
 * @author ber
 * @version 1.0
 * @date 22/3/26 12:56
 */
public class T002 {


    /**
     * 题：https://leetcode-cn.com/problems/add-two-numbers/
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 按照加法运算规则进行模拟
        int tmp = 0;
        // 建立两个链表，一个用于记录头结点，另一个用于后续新增结点
        ListNode ans = new ListNode(), head = new ListNode();
        ans = head;
        // 遍历两个链表
        while (l1 != null || l2 != null) {
            int sum;
            ListNode node;
            // l2不为空
            if (l1 == null) {
                // 计算时记得将进位的tmp加入
                sum = (l2.val + tmp);
                node = new ListNode(sum % 10);
                l2 = l2.next;
            }
            // l1不为空
            else if (l2 == null) {
                sum = (l1.val + tmp);
                node = new ListNode(sum % 10);
                l1 = l1.next;
            }
            // l1、l2都不为空
            else {
                sum = (l1.val + l2.val + tmp);
                node = new ListNode(sum % 10);
                l1 = l1.next;
                l2 = l2.next;
            }
            // 判断进位
            if (sum > 9) {
                tmp = 1;
            } else {
                tmp = 0;
            }
            head.next = node;
            head = head.next;
        }
        // 最后的进位
        if (tmp > 0) {
            head.next = new ListNode(tmp);
        }
        return ans.next;
    }


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
}
