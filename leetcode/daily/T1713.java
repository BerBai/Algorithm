package daily;

import java.util.*;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/26 08:50
 */
public class T1713 {
    // 题超出时间限制
    class Solution {
        public int minOperations(int[] target, int[] arr) {
            ArrayList<Integer> list = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();
            // 记录target元素的下标
            for (int i = 0; i < target.length; i++) {
                map.put(target[i], i);
            }
            // 记录arr对应target元素的下标
            for (int item : arr) {
                if (map.containsKey(item)) {
                    list.add(map.get(item));
                }
            }
            int maxNum = 1;
            if (list.size() > 0) {
                // 寻找list的最长递增串长度
                int[] dp = new int[list.size()];
                dp[0] = 1;
                for (int i = 1; i < list.size(); i++) {
                    dp[i] = 1;
                    for (int j = 0; j < i; j++) {
                        if (list.get(i) > list.get(j)) {
                            dp[i] = Math.max(dp[i], dp[j] + 1);
                        }
                    }
                    maxNum = Math.max(maxNum, dp[i]);
                }
            } else {
                maxNum = 0;
            }
            return target.length - maxNum;
        }
    }

    // 优化最长递增序列
    class Solution2 {
        public int minOperations(int[] target, int[] arr) {
            ArrayList<Integer> list = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();
            // 记录target元素的下标
            for (int i = 0; i < target.length; i++) {
                map.put(target[i], i);
            }
            // 记录arr对应target元素的下标
            for (int item : arr) {
                if (map.containsKey(item)) {
                    list.add(map.get(item));
                }
            }
            int maxNum = 1;
            if (list.size() > 0) {
                // 寻找list的最长递增串长度
                int[] d = new int[list.size() + 1];
                d[maxNum] = list.get(0);
                for (int i = 1; i < list.size(); i++) {
                    if (list.get(i) > d[maxNum]) {
                        d[++maxNum] = list.get(i);
                    } else {
                        int l = 1, r = maxNum, pos = 0;
                        while (l <= r) {
                            int mid = (l + r) >> 1;
                            if (d[mid] < list.get(i)) {
                                pos = mid;
                                l = mid + 1;
                            } else {
                                r = mid - 1;
                            }
                        }
                        d[pos + 1] = list.get(i);
                    }
                }
            } else {
                maxNum = 0;
            }
            return target.length - maxNum;
        }
    }

    class Solution3 {
        public int minOperations(int[] target, int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < target.length; i++) {
                map.put(target[i], i);
            }
            ArrayList<Integer> list = new ArrayList<>();
            for (int item : arr) {
                if (map.containsKey(item)) {
                    int index = map.get(item);
                    int l = 0, r = list.size();
                    while (l < r) {
                        int mid = (l + r) >> 1;
                        if (list.get(mid) >= index) {
                            r = mid;
                        } else {
                            l = mid + 1;
                        }
                    }
                    if (l == list.size()) {
                        list.add(index);
                    } else {
                        list.set(l, index);
                    }
                }
            }
            return target.length - list.size();
        }
    }
}
