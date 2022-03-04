package daily;

import java.util.ArrayList;
import java.util.List;
public class T1380 {
    // 利用两个辅助数组记录下行最下下标、列最大下标
// 再从记录中寻找符合列最大、行最小条件的元素
    class Solution {
        public List<Integer> luckyNumbers (int[][] matrix) {
            int n,m;
            n = matrix.length;
            m = matrix[0].length;
            List<Integer> ans = new ArrayList<>();
            int x[] = new int[n];
            int y[] = new int[m];
            for(int i=0;i<n;i++) {
                for(int j=0;j<m;j++) {
                    if(matrix[i][j] < matrix[i][x[i]]) {
                        x[i] = j;
                    }
                    if(matrix[i][j] > matrix[y[j]][j]) {
                        y[j] = i;
                    }
                }
            }
            for(int i=0;i<n;i++) {
                if(i == y[x[i]]) {
                    ans.add(matrix[i][x[i]]);
                }
            }
            return ans;
        }
    }
}