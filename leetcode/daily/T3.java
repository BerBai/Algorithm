package daily;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/2 08:32
 */
public class T3 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            // 初始256大小，因为所有字符也就这么多，值记录着最后一次出现时在s中的下标，没有则是-1
            int[] tmp = new int[256];
            Arrays.fill(tmp, -1);
            int ans = 0, fa = 0;
            for (int i = 0; i < n; i++) {
                // 若字符在fa之前出现过，更新fa
                if (tmp[s.charAt(i)] != 0 && tmp[s.charAt(i)] >= fa) {
                    fa = tmp[s.charAt(i)] + 1;
                }
                // 记录字符最后出现的下标
                tmp[s.charAt(i)] = i;
                // 计算最长字串
                ans = Math.max(ans, i - fa + 1);
            }
            return ans;
        }
    }

    class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            // 哈希集合，记录每个字符是否出现过
            Set<Character> occ = new HashSet<Character>();
            int n = s.length();
            // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
            int rk = -1, ans = 0;
            for (int i = 0; i < n; ++i) {
                if (i != 0) {
                    // 左指针向右移动一格，移除一个字符
                    occ.remove(s.charAt(i - 1));
                }
                while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                    // 不断地移动右指针
                    occ.add(s.charAt(rk + 1));
                    ++rk;
                }
                // 第 i 到 rk 个字符是一个极长的无重复字符子串
                ans = Math.max(ans, rk - i + 1);
            }
            return ans;
        }
    }
}
