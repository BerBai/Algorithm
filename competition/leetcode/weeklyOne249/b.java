package leetcode.weeklyOne249;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/14 21:08
 */
public class b {
    public static int countPalindromicSubsequence(String s) {
        int ans = 0;
        for (char i = 'a'; i <= 'z'; i++) {
            int l = 0, r = s.length() - 1;
            while (i != s.charAt(l) && l < r - 1) {
                l++;
            }
            while (i != s.charAt(r) && r > l + 1) {
                r--;
            }
            if (l <= r + 2) {
                // 可换用set集合去重
                List<Character> arr = new ArrayList<>();
                for (int k = l + 1; k < r; k++) {
                    if (!arr.contains(s.charAt(k))) {
                        arr.add(s.charAt(k));
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(b.countPalindromicSubsequence("aabca"));
    }
}
