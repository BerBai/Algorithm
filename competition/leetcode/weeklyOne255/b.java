package leetcode.weeklyOne255;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/22 10:33
 */
public class b {
    class Solution {
        public String findDifferentBinaryString(String[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            Set<String> set = Arrays.stream(nums).collect(Collectors.toSet());
            StringBuilder tmp = new StringBuilder();
            int i = 0;
            while (i < n) {
                i++;
                tmp.append("0");
            }
            i = 1;
            while (set.contains(tmp.toString())) {
                String s = Integer.toBinaryString(i);
                i++;
                if (s.length() != tmp.length()) {
                    tmp.replace(tmp.length() - s.length() - 1, tmp.length() - 1, s);
                } else {
                    tmp.replace(0, tmp.length(), s);
                }
            }
            return tmp.toString();
        }
    }
}
