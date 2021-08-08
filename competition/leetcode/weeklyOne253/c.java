package leetcode.weeklyOne253;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/8 15:49
 */
public class c {
    class Solution {
        char[] chars;

        public int minSwaps(String s) {
            chars = s.toCharArray();
            int ans = 0, count = 0;
            for (char c : chars) {
                if (c == '[') {
                    count++;
                } else {
                    if (count == 0) {
                        ans++;
                        count++;
                    } else {
                        count--;
                    }
                }
            }
            return ans;
        }
    }
}
