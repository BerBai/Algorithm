package leetcode.weeklyOne254;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/15 10:42
 */
public class a {
    class Solution {
        public int numOfStrings(String[] patterns, String word) {
            int ans = 0;
            for (String str : patterns) {
                if (word.contains(str)) {
                    ans++;
                }
            }
            return ans;
        }
    }
}
