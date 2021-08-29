package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/29 08:18
 */
public class T1588 {
    // 模拟
    class Solution {
        public int sumOddLengthSubarrays(int[] arr) {
            int n = arr.length, ans = 0;

            for (int i = 1; i <= n; i = i + 2) {
                for (int j = 0; j < n; j++) {
                    for (int k = j; i + j <= n && k < i + j; k++) {
                        ans += arr[k];
                    }
                }
            }
            return ans;
        }
    }

    /**
     * 第一位出现(n+1)/2次
     * 当前位比上一位多 (n - i + 1) / 2 - (i + 1) / 2
     * 首尾对应位置出现次数相同(对称性)
     */
    class Solution2 {
        public int sumOddLengthSubarrays(int[] arr) {
            int n = arr.length;
            int ans = 0;
            for (int l = 0, r = n - 1, times = (n + 1) / 2; l <= r; r--) {
                if (l < r) {
                    ans += times * (arr[l] + arr[r]);
                } else {
                    ans += times * arr[l];
                }
                times += (n - ++l + 1) / 2 - (l + 1) / 2;
            }
            return ans;
        }
    }
}
