package offer;

import java.util.Stack;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/1 09:01
 */
public class Offer31 {
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            if (pushed == null || pushed.length == 0) {
                return true;
            }
            Stack<Integer> stack = new Stack<>();
            stack.push(pushed[0]);
            int i = 1, j = 0, n = pushed.length, m = popped.length;
            while (!stack.isEmpty()) {
                if (i == n && j != m && stack.peek() != popped[j]) {
                    return false;
                }
                while (stack.peek() != popped[j] && i < n && pushed[i] != popped[j]) {
                    stack.push(pushed[i++]);
                }
                if (stack.peek() == popped[j] || (i < n && pushed[i] == popped[j])) {
                    if (stack.peek() == popped[j]) {
                        stack.pop();
                    } else {
                        i++;
                    }
                    j++;
                }
                if (stack.isEmpty() && i < n) {
                    stack.push(pushed[i++]);
                }
            }
            return true;
        }
    }
    // 重新整理
    class Solution2 {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> stack = new Stack<>();
            int i = 0;
            for (int item : pushed) {
                stack.push(item);
                while(!stack.isEmpty() && stack.peek() == popped[i]) {
                    stack.pop();
                    i++;
                }
            }
            return stack.isEmpty();
        }
    }
}
