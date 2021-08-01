package daily;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/1 08:21
 */
public class T1337 {
    class Solution {
        public int[] kWeakestRows(int[][] mat, int k) {
            List<int[]> list = new ArrayList<>();
            int n = mat.length, m = mat[0].length;
            for (int i = 0; i < n; i++) {
                int[] tmp = {i, 0};
                for (int j = 0; j < m; j++) {
                    if (mat[i][j] == 1) {
                        tmp[1]++;
                    }
                }
                list.add(tmp);
            }
            Collections.sort(list, (a, b) -> {
                if (a[1] != b[1]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            });
            int[] ans = new int[k];
            while (k != 0) {
                ans[--k] = list.get(k)[0];
            }
            return ans;
        }
    }
}
