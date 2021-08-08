package leetcode.weeklyTwo58;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/7 22:14
 */
public class d {
    class Solution {
        public long maxProduct(String s) {
            int n = s.length();

            //---------- 马拉车算法求臂长数组 -------------//
            int[] arm_len = new int[n];
            int center = -1;
            int maxR = -1;
            for (int i = 0; i < n; i++) {
                int cur_arm_len = 0;
                if (i <= maxR) {
                    int mirror_i = 2 * center - i;
                    int cur_min_len = Math.min(arm_len[mirror_i], maxR - i);
                    cur_arm_len = center_spread_get_arm_len(s, i - cur_min_len, i + cur_min_len);
                } else {
                    cur_arm_len = center_spread_get_arm_len(s, i, i);
                }

                arm_len[i] = cur_arm_len;
                if (i + cur_arm_len > maxR) {
                    maxR = i + cur_arm_len;
                    center = i;
                }
            }

            //--------- 前i个中，最大的臂长
            int[] prefix_max_arm_len = new int[n];
            int left_center = 0;
            for (int i = 1; i < n; i++) {
                while (left_center + arm_len[left_center] < i){
                    left_center++;
                }
                prefix_max_arm_len[i] = Math.max(prefix_max_arm_len[i - 1], i - left_center);
            }

            //-------- 从i往右中，最大的臂长
            int[] suffix_max_arm_len = new int[n];
            int right_center = n - 1;
            for (int i = n - 2; i > -1; i--) {
                while (right_center - arm_len[right_center] > i){
                    right_center--;
                }
                suffix_max_arm_len[i] = Math.max(suffix_max_arm_len[i + 1], right_center - i);
            }

            long res = 0;
            for (int i = 0; i < n - 1; i++) {
                long l_len = 2 * prefix_max_arm_len[i] + 1;
                long r_len = 2 * suffix_max_arm_len[i + 1] + 1;
                res = Math.max(res, l_len * r_len);
            }
            return res;

        }


        public int center_spread_get_arm_len(String s, int l, int r) {
            int n = s.length();
            while (0 <= l && r < n && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            return (r - l - 2) / 2;
        }
    }
}
