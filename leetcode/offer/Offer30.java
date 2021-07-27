package offer;

import java.util.LinkedList;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/27 10:10
 */
public class Offer30 {
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

}
