public class T1020 {
    
}

/** 求闭合区域1的数量 */
// 1.边缘区域的1赋值为0
// 2.计算剩余1的个数
class Solution {
    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int m, n;
    private int[][] visited;

    public void dfs(int i, int j) {
        visited[i][j] = 0;
        for(int k=0;k<4;k++) {
            int x = i + dirs[k][0];
            int y = j + dirs[k][1];
            if(x>=0 && x<m && y>=0 && y<n && visited[x][y] == 1) {
                dfs(x, y);
            }
        }
    }
    
    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = grid;
        for(int i = 0; i < m; i++) {
            if(visited[i][0] == 1) {
                dfs(i, 0);
            }
            if(visited[i][n-1] == 1) {
                dfs(i, n-1);
            }
        }

        for(int j = 0; j<n;j++) {
            if(visited[0][j] == 1) {
                dfs(0, j);
            }
            if(visited[m-1][j] == 1) {
                dfs(m-1, j);
            }
        }

        int ans = 0;
        for(int i=0;i<m;i++) {
            for(int j=0; j<n;j++) {
                if(visited[i][j] == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }
}