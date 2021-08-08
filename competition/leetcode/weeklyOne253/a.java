package leetcode.weeklyOne253;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/8 10:46
 */
public class a {
    class Solution {
        public boolean isPrefixString(String s, String[] words) {
            StringBuilder ans = new StringBuilder();
            for(int i=0;i<words.length;i++) {
                ans.append(words[i]);
                if(s.equals(ans.toString())) {
                    return true;
                }
            }
            return false;
        }
    }
}
