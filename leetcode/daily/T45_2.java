package daily;

/**
 * @author ber
 * @version 1.0
 * @date 21/9/17 09:49
 */
public class T45_2 {
    // 每次最大步数前进
    class Solution {
        public int jump(int[] nums) {
            int n = nums.length;
            int end = 0;
            int maxStep = 0;
            int minStep = 0;
            for (int i = 0; i < n - 1; i++) {
                maxStep = Math.max(maxStep, i + nums[i]);
                if (i == end) {
                    end = maxStep;
                    minStep++;
                }
            }
            return minStep;
        }
    }

    // 反向查找
    class Solution2 {
        public int jump(int[] nums) {
            int n = nums.length;
            int index = n - 1;
            int minStep = 0;
            while (index > 0) {
                for (int i = 0; i < index; i++) {
                    if (index <= i + nums[i]) {
                        index = i;
                        minStep++;
                        break;
                    }
                }
            }
            return minStep;
        }
    }
}
