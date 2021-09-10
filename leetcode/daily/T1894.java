package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/10 15:42
 */
public class T1894 {
    class Solution {
        public int chalkReplacer(int[] chalk, int k) {
            int n = chalk.length, ans = -1;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += chalk[i];
            }
            k %= sum;
            for (int i = 0; i < n; i++) {
                k -= chalk[i];
                if (k < 0) {
                    ans = i;
                    break;
                }
            }
            return ans;
        }
    }
}
