package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/22 09:20
 */
public class T789 {
    class Solution {
        public boolean escapeGhosts(int[][] ghosts, int[] target) {
            int tmp = Math.abs(target[0]) + Math.abs(target[1]);
            for (int i = 0; i < ghosts.length; i++) {
                int k = Math.abs(target[0] - ghosts[i][0]) + Math.abs(target[1] - ghosts[i][1]);
                if(k<=tmp) {
                    return false;
                }
            }
            return true;
        }
    }
}
