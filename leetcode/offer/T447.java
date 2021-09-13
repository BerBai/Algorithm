package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/13 17:05
 */
public class T447 {
    /**
     * 题目所描述的回旋镖可以视作一个 v 型的折线。
     * 1.枚举举每个点，将其设为折点a
     * 2.假设有m个点到点a的距离相等，则任选两个点都可以形成回旋镖。有m*(m-1)个
     * 3.每次遍历时用map记录，再统计下map中距离相等的点即可得到答案
     */
    class Solution {
        public int numberOfBoomerangs(int[][] points) {
            int ans = 0;
            for (int[] i : points) {
                Map<Integer, Integer> map = new HashMap<>();
                for (int[] j : points) {
                    int dis = (i[0] - j[0]) * (i[0] - j[0]) + (i[1] - j[1]) * (i[1] - j[1]);
                    map.put(dis, map.getOrDefault(dis, 0) + 1);
                }
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    int m = entry.getValue();
                    ans += m * (m - 1);
                }
            }
            return ans;
        }
    }
}
