package leetcode.weeklyOne253;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/8 15:55
 */
public class d {
    class Solution {
        public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
            //最长上升子序列
            int[] stack = new int[obstacles.length];//恒定的
            int top = -1;
            int[] res = new int[obstacles.length];
            for (int i = 0; i < obstacles.length; i++) {
                if (top == -1 || obstacles[i] >= stack[top]) {
                    stack[++top] = obstacles[i];
                    res[i] = top + 1;
                } else {
                    //二分
                    int l = 0, r = top, m;
                    while (l < r) {
                        m = l + (r - l) / 2;
                        if (stack[m] <= obstacles[i]) {
                            l = m + 1;
                        } else {
                            r = m;
                        }
                    }
                    stack[r] = obstacles[i];
                    res[i] = r + 1;
                }
            }
            return res;
        }
    }
}
