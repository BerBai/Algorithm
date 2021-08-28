package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/28 15:26
 */
public class T278 {
    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int left = 1, right = n, mid;
            while (left < right) {
                // 防止计算时溢出
                mid = left + (right - left) / 2;
                if (!isBadVersion(mid)) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }

    }

    // 题目要求
    private class VersionControl {
        boolean isBadVersion(int version) {
            return false;
        }
    }
}
