package leetcode.weeklyTwo56;

import java.util.Arrays;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/14 19:19
 */
public class d {
    public static int minCost(int maxTime, int[][] edges, int[] passingFees) {
        // dp[i][j]表示在i时间达到j点所花费费用
        int[][] dp = new int[maxTime + 1][passingFees.length];
        // 赋值一个超过最大花费的值
        for (int[] j : dp) {
            Arrays.fill(j, Integer.MAX_VALUE / 4);
        }
        // 更新初始费用，及起点0点所花费的费用
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = passingFees[0];
        }
        int res = Integer.MAX_VALUE / 4;
        // 第一层遍历时间，第二层遍历路径
        // 虽然dp的j代表城市，但是循环遍历城市需要另外构建城市map，存储每个城市的连通道路。所以内层遍历路径。
        for (int i = 1; i <= maxTime; i++) {
            for (int j = 0; j < edges.length; j++) {
                int city1 = edges[j][0];
                int city2 = edges[j][1];
                int time = edges[j][2];
                if (i >= time) {
                    // 双向路
                    dp[i][city1] = Math.min(dp[i][city1], dp[i - time][city2] + passingFees[city1]);
                    dp[i][city2] = Math.min(dp[i][city2], dp[i - time][city1] + passingFees[city2]);
                }
            }
            res = Math.min(res, dp[i][passingFees.length - 1]);
        }
        // 可以在第一层循环中计算最小费用
//        for (int i = 1; i <= maxTime; i++) {
//            res = Math.min(res, dp[i][passingFees.length - 1]);
//        }
        return res == Integer.MAX_VALUE / 4 ? -1 : res;
    }

    public static void main(String[] args) {
        System.out.println(d.minCost(30, new int[][]{{0, 1, 10}, {1, 2, 10}, {2, 5, 10}, {0, 3, 1}, {3, 4, 10}, {4, 5, 15}}, new int[]{5, 1, 2, 20, 20, 3}));
    }
}
