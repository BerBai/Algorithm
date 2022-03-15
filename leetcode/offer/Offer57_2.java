package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ber
 * @version 1.0
 * @date 22/3/15 12:05
 */
public class Offer57_2 {
    class Solution {
        public int[][] findContinuousSequence(int target) {
            List<int[]> list = new ArrayList<>();
            int sum = 0;
            for(int l = 1,r = 1;r<target;r++) {
                sum += r;
                while(sum > target) {
                    sum -= l;
                    l++;
                }
                if(sum == target) {
                    int[] tmp = new int[r-l +1 ];
                    for(int i=0;i<tmp.length;i++) {
                        tmp[i] = l + i;
                    }
                    list.add(tmp);
                }
            }
            int[][] ans = new int[list.size()][];
            for(int i=0;i<list.size();i++) {
                ans[i] = list.get(i);
            }
            return ans;
        }
    }
}
