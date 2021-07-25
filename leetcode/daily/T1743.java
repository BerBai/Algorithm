package daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/25 08:37
 */
public class T1743 {
    class Solution {
        public int[] restoreArray(int[][] adjacentPairs) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int[] item : adjacentPairs) {
                map.putIfAbsent(item[0], new ArrayList<>());
                map.putIfAbsent(item[1], new ArrayList<>());
                map.get(item[0]).add(item[1]);
                map.get(item[1]).add(item[0]);
            }
            int n = adjacentPairs.length + 1;
            int ans[] = new int[n];
            for (Map.Entry<Integer, List<Integer>> item : map.entrySet()) {
                int e = item.getKey();
                final List<Integer> value = item.getValue();
                if (value.size() == 1) {
                    ans[0] = e;
                    break;
                }
            }
            ans[1] = map.get(ans[0]).get(0);
            for (int i = 2; i < n; i++) {
                final List<Integer> valueList = map.get(ans[i - 1]);
                ans[i] = (ans[i - 2] == valueList.get(0) ? valueList.get(1) : valueList.get(0));
            }
            return ans;
        }
    }
}
