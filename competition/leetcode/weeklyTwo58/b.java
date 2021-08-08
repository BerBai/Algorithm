package leetcode.weeklyTwo58;

import java.util.Arrays;

/**
 * @author ber
 * @version 1.0
 * @date 21/8/7 22:14
 */
public class b {
    class Solution {
        int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};

        public boolean checkMove(char[][] board, int rMove, int cMove, char color) {

            for (int[] d : dir) {
                int x = rMove + d[0], y = cMove + d[1], len = 0;
                boolean flag = false;
                while (x >= 0 && x < 8 && y >= 0 && y < 8) {

                    if (board[x][y] == '.') {
                        break;
                    }
                    if (board[x][y] == color) {
                        if (len >= 1){
                            return true;
                        }
                        break;
                    }
                    x = x + d[0];
                    y = y + d[1];
                    len++;
                }
            }
            return false;

        }
    }
}
