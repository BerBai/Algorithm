package offer;

import java.util.LinkedList;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/27 10:10
 */
public class Offer30 {
    // LinkedList的add()是在尾部进。peek()是头部出
    /**
     * 两个队列实现，stackA记录栈元素，stackB记录栈元素位置的最小元素
     * 1. 进栈时，stackB为空或stackB栈顶元素大于等于进栈元素时更新stackB
     * 2. 出栈时，出栈元素与stackB栈顶元素相等时，一同出栈
     */
    class MinStack {
        LinkedList<Integer> stackA, stackB;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stackA = new LinkedList<>();
            stackB = new LinkedList<>();
        }

        public void push(int x) {
            stackA.add(x);
            if (stackB.isEmpty() || stackB.peekLast() >= x) {
                stackB.add(x);
            }
        }

        public void pop() {
            if (stackA.removeLast().equals(stackB.peekLast())) {
                stackB.removeLast();
            }
        }

        public int top() {
            return stackA.peekLast();
        }

        public int min() {
            return stackB.peekLast();
        }
    }

    // 区分LinkedList的pop()元素在头部进、push()元素在尾部出
    class MinStack2 {
        LinkedList<Integer> stackA, stackB;

        /**
         * initialize your data structure here.
         */
        public MinStack2() {
            stackA = new LinkedList<>();
            stackB = new LinkedList<>();
        }

        public void push(int x) {
            stackA.push(x);
            if (stackB.isEmpty() || stackB.peek() >= x) {
                stackB.push(x);
            }
        }

        public void pop() {
            if (stackA.pop().equals(stackB.peek())) {
                stackB.pop();
            }
        }

        public int top() {
            return stackA.peek();
        }

        public int min() {
            return stackB.peek();
        }
    }

    // 定义一个带最小值的链表，记录栈元素位置的最小值
    class MinStack3 {
        private class Node{
            int val;
            int minVal;
            Node next;
    
            public Node(int val, int minVal, Node next) {
                this.val = val;
                this.minVal = minVal;
                this.next = next;
            }
        }
    
        private Node stack;
    
        /** initialize your data structure here. */
        public MinStack() {
    
        }
        
        public void push(int x) {
            if(stack == null) {
                stack = new Node(x, x, null);
            } else {
                stack = new Node(x, Math.min(stack.minVal, x), stack);
            }
        }
        
        public void pop() {
            stack = stack.next;
        }
        
        public int top() {
            return stack.val;
        }
        
        public int min() {
            return stack.minVal;
        }
    }
}
