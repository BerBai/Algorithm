package leetcode.weeklyOne255;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/22 10:59
 */
public class c {
    class Solution {
        public int minimizeTheDifference(int[][] mat, int target) {
            int m = mat.length, n = mat[0].length;
            int i = 0, j = 0;
            for (i = 0; i < m; i++) {
                Arrays.sort(mat[i]);
            }
            int k = 0;
            Set<Integer>[] sets = new HashSet[m];
            for (i = 0; i < m; i++) {
                sets[i] = new HashSet<>();
                for (j = 0; j < n; j++) {
                    sets[i].add(mat[i][j]);
                }
            }

            merge(sets, 0, m - 1);

            int min = Integer.MAX_VALUE, ans = 0;
            for (Integer num : sets[0]) {
                if (Math.abs(num - target) < min) {
                    min = Math.abs(num - target);
                    ans = num;
                }
            }

            //System.out.println(sets[0]);

            return min;
        }

        public void merge(Set<Integer>[] sets, int l, int r) {
            if (l >= r) {
                return;
            }
            int mid = l + r >> 1;
            merge(sets, l, mid);
            merge(sets, mid + 1, r);
            int m = sets[l].size(), n = sets[mid + 1].size();
            int i = 0, j = 0;
            Set<Integer> temp = new HashSet<>();
            int[] a = new int[m];
            int[] b = new int[n];
            for (Integer num : sets[l]) {
                a[i++] = num;
            }
            for (Integer num : sets[mid + 1]) {
                b[j++] = num;
            }
            for (i = 0; i < m; i++) {
                for (j = 0; j < n; j++) {
                    temp.add(a[i] + b[j]);
                }
            }
            sets[l] = new HashSet<>(temp);
        }
    }
}
