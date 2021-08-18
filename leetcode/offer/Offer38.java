package offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/17 20:48
 */
public class Offer38 {
    class Solution {
        char[] chars;
        List<String> ans = new LinkedList<>();

        public String[] permutation(String s) {
            int n = s.length();
            chars = s.toCharArray();
            dfs(0);
            return ans.toArray(new String[ans.size()]);
        }

        public void dfs(int x) {
            if (x == chars.length - 1) {
                ans.add(String.valueOf(chars));
                return;
            }
            Set<Character> set = new HashSet<>();
            for (int i = x; i < chars.length; i++) {
                if (set.contains(chars[i])) {
                    continue;
                }
                set.add(chars[i]);
                char tmp = chars[i];
                chars[i] = chars[x];
                chars[x] = tmp;

                dfs(x + 1);

                tmp = chars[i];
                chars[i] = chars[x];
                chars[x] = tmp;
            }
        }
    }
}
