package top100.string;

/**
 * @author ber
 * @version 1.0
 * @date 22/3/30 13:52
 */
public class T019 {
    /**
     * 题：https://leetcode-cn.com/problems/RQku0D/
     * 删除一个元素后，字符串是回文串
     *
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        for (int left = 0, right = s.length() - 1; left < right; left++, right--) {
            // 如果不相等，则分两种情况：删除左边的元素，或者右边的元素，再判断各自是否回文，满足一种即可。
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
        }
        return true;
    }

    // 判断字符串 s 的 [left, right] 是否回文
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
