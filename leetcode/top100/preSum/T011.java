package top100.preSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ber
 * @version 1.0
 * @date 22/4/2 12:57
 */
public class T011 {

    /**
     * 题：https://leetcode-cn.com/problems/A1NYOS/
     * 从第0位开始数，到第i位时，0比1多3个；到第j位时，0也比1多3个，他们中间的个数必然相等。
     *
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        int[] preSums = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            preSums[i] = preSums[i - 1] + (nums[i - 1] == 0 ? -1 : 1);
            System.out.printf(preSums[i] + " ");
        }
        int ans = 0;
        for (int i = 0; i <= len; i++) {
            for (int j = i + 1; j <= len; j++) {
                if (preSums[j] - preSums[i] == 0) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;

    }

    // 优化， 用map记录前缀和的最小下标
    public int findMaxLength2(int[] nums) {
        int len = nums.length;
        // 记录前缀和最开始出现下标，即出现该前缀和时的最小下标
        Map<Integer, Integer> preSumCnt = new HashMap<>();
        int preSum = 0;
        // i=0时 下标为-1
        preSumCnt.put(preSum, -1);
        int ans = 0;
        for (int i = 0; i < len; i++) {
            // 转换成-1 、 1数组
            preSum += (nums[i] == 0 ? -1 : 1);
            if (preSumCnt.containsKey(preSum)) {
                // 当map中存在相同的前缀和时，此时map中（相同的前缀和下标，i] 该区间是符合相同0/1个数的
                ans = Math.max(ans, i - preSumCnt.get(preSum));
            } else {
                // 不存在相同前缀和，存入map
                preSumCnt.put(preSum, i);
            }
        }
        return ans;
    }
}
