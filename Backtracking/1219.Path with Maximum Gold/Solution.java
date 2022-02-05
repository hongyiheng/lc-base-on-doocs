class Solution {
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    boolean[][] vis;
    int[][] g;
    int m, n;
    public int getMaximumGold(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        vis = new boolean[m][n];
        g = grid;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] != 0) {
                    ans = Math.max(ans, dfs(i, j));
                }
            }
        }
        return ans;
    }

    public int dfs(int x, int y) {
        if (g[x][y] == 0 || vis[x][y]) {
            return 0;
        }
        vis[x][y] = true;
        int ans = 0;
        for (int[] d : dirs) {
            int nx = x + d[0], ny = y + d[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                continue;
            }
            if (g[nx][ny] == 0 || vis[nx][ny]) {
                continue;
            }
            ans = Math.max(ans, dfs(nx, ny));
        }
        vis[x][y] = false;
        return g[x][y] + ans;
    }
}