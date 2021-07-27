package leetcode.weeklyOne249;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ber
 * @version 1.0
 * @date 21/7/26 20:57
 */
public class c {
    class Solution {
        long MOD = (long) (1e9 + 7);

        public int colorTheGrid(int m, int n) {
            //每一行有多少种可能方案，即m位三进制数有多少个
            int len = (int) Math.pow(3, m);
            //dp[i][j]表示第i行，颜色方案的三进制数对应的十进制为j时，有多少种方案
            long[][] dp = new long[n][len];
            //isValid[j]表示j代表的颜色方案是否符合要求
            boolean[] isValid = new boolean[len];
            //colorArray[j]表示j代表的颜色方案
            int[][] colorArray = new int[len][];
            //第0行：判断每个三进制数代表的方案有没有相邻颜色相同情况
            for (int j = 0; j < len; j++) {
                int num = j;
                //j代表的颜色方案
                int[] color = new int[m];
                int index = 0;
                while (num != 0) {
                    color[index++] = num % 3;
                    num /= 3;
                }
                //保存j代表的颜色方案
                colorArray[j] = color;
                //j代表的方案是否符合要求
                boolean flag = true;
                for (int k = 1; k < m; k++) {
                    //相邻的颜色相同
                    if (color[k] == color[k - 1]) {
                        //j代表的颜色方案不符合要求
                        flag = false;
                        break;
                    }
                }
                //j代表的颜色方案符合要求
                if (flag) {
                    isValid[j] = true;
                    //第0行为j时有一种方案
                    dp[0][j] = 1;
                }
            }
            //第1行到第n-1行
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < len; j++) {
                    //j方案符合要求
                    if (isValid[j]) {
                        //获取j对应的颜色方案
                        int[] colorJ = colorArray[j];
                        for (int k = 0; k < len; k++) {
                            //k方案符合要求
                            if (isValid[k]) {
                                //获取k对应的颜色方案
                                int[] colorK = colorArray[k];
                                //i-1行为j，i行为k是否符合要求
                                boolean flag = true;
                                for (int l = 0; l < m; l++) {
                                    if (colorJ[l] == colorK[l]) {
                                        flag = false;
                                        break;
                                    }
                                }
                                //i-1行为j，i行为k符合要求
                                if (flag) {
                                    //dp[i][k]]表示i行，方案代表的三进制数的十进制表示为k时的方案数
                                    //dp[i-1][j]表示i-1行，方案代表的三进制的十进制表示为数为j时的方案数
                                    dp[i][k] = (dp[i][k] + dp[i - 1][j]) % MOD;
                                }
                            }
                        }
                    }
                }
            }
            long sum = 0;
            //将第n-1行所有方案数加和，即为答案
            for (int j = 0; j < len; j++) {
                sum = (sum + dp[n - 1][j]) % MOD;
            }
            return (int) sum;
        }
    }
}
