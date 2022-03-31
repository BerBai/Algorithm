package top100.slidingWindow;

/**
 * @author ber
 * @version 1.0
 * @date 22/3/31 12:23
 */
public class T017 {
    /**
     * 题：https://leetcode-cn.com/problems/M1oyTv/
     */
    boolean hasAns = false;
    int resLeft = 0;
    int resRight = 100000;
    int len = 100000;

    public String minWindow(String s, String t) {
        char[] tchars = t.toCharArray();
        int left = 0;
        int right = 0;
        int targetDiff = t.length() - 1;

        int[] charsMap = new int[58];
        for (char tchar : tchars) {
            ++charsMap[tchar - 'A'];
        }
        char[] schars = s.toCharArray();
        int nextIndex = 26;
        while (right < schars.length) {
            --charsMap[schars[right] - 'A'];
            if (right - left >= targetDiff && charsMap[nextIndex] <= 0) {
                nextIndex = getIndexOfInvalidChar(charsMap);
                // 说明当前子串满足条件
                if (nextIndex == 26) {
                    hasAns = true;
                    int i = schars[left] - 'A';
                    while (charsMap[i] < 0 && left < right) {
                        ++charsMap[i];
                        ++left;
                        i = schars[left] - 'A';
                    }
                    if (right - left < len) {
                        len = right - left;
                        resLeft = left;
                        resRight = right;
                    }
                }
            }
            ++right;
        }

        return !hasAns ? "" : s.substring(resLeft, resRight + 1);
    }

    /**
     * 当该子串满足时, 返回 26; 否则返回第一个不满足条件的字符下标。
     */
    public int getIndexOfInvalidChar(int[] charsMap) {
        for (int i = 0; i < charsMap.length; i++) {
            if (charsMap[i] > 0) {
                return i;
            }
        }
        // 'A' + 26 = '['
        // '[' 字符数必定等于 0
        return 26;
    }
}
