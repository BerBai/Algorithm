package offer;

import java.util.LinkedList;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/27 10:10
 */
public class Offer30 {
    // LinkedList的add()，是在尾部进。peek()是头部出
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

    // 区分LinkedList的pop()、push()，元素在头部进、出
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

}
