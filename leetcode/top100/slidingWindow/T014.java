package top100.slidingWindow;

import java.util.Arrays;

/**
 * @author ber
 * @version 1.0
 * @date 22/4/3 10:49
 */
public class T014 {
    public boolean checkInclusion(String s1, String s2) {
        // 判断s2中连线子串是否满足s1字符
        // 1.s2子串长度满足s1的长度 2.维持长度为s1的滑动窗口，判断元素与s1是否相等
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; i++) {
            // 计算s1串字符
            cnt1[c1[i] - 'a']++;
            // 维护一个长度为n的滑动窗口
            cnt2[c2[i] - 'a']++;
        }
        for (int i = n; i < m; i++) {
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
            cnt2[c2[i - n] - 'a']--;
            cnt2[c2[i] - 'a']++;
        }
        return Arrays.equals(cnt1, cnt2);
    }

    public static void main(String[] args) {
        T014 t014 = new T014();
        System.out.println(t014.checkInclusion("ab", "eidbaooo"));
    }
}
