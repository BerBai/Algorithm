package daily;

import java.util.LinkedList;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/12 10:27
 */
public class T678 {
    static class Solution {

        public static boolean test(String s) {
            LinkedList<Integer> stack = new LinkedList<>();
            char[] chars = s.toCharArray();
            int n = s.length(), i;
            for (i = 0; i < n; i++) {
                if (chars[i] == '(') {
                    stack.offerLast(i);
                } else if (chars[i] == ')') {
                    if (!stack.isEmpty()) {
                        stack.removeLast();
                    } else {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }

        public static boolean checkValidString(String s) {
            LinkedList<Integer> stackA = new LinkedList<>();
            LinkedList<Integer> stackB = new LinkedList<>();
            char[] chars = s.toCharArray();
            int n = s.length(), i;
            for (i = 0; i < n; i++) {
                if (chars[i] == '(') {
                    // 记录下（下标
                    stackA.offerLast(i);
                } else if (chars[i] == '*') {
                    // 记录下*下标
                    stackB.offerLast(i);
                } else if (chars[i] == ')') {
                    // 优先于（进行匹配，没有（则与*匹配，两者都没有说明不能匹配
                    if (!stackA.isEmpty()) {
                        stackA.removeLast();
                    } else if (!stackB.isEmpty()) {
                        stackB.removeLast();
                    } else {
                        return false;
                    }
                }
            }
            while (!stackA.isEmpty() && !stackB.isEmpty()) {
                Integer a = stackA.removeLast();
                Integer b = stackB.removeLast();
                // 如果（在*前，不能匹配
                if (a > b) {
                    return false;
                }
            }
            // 最后根据（的情况进行判断，有剩余则说明存在（不能被匹配
            return stackA.isEmpty();
        }
    }

    public static void main(String[] args) {

        System.out.println(Solution.checkValidString("()(**"));
        System.out.println(Solution.test("(()"));
        System.out.println(Solution.test("(()()))"));
        System.out.println(Solution.checkValidString("(()()*()"));
    }
}
