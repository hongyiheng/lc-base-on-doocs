class Solution {

    int[][] grid;
    int m, n, cnt, ans;

    public void dfs(int x, int y, int vis) {
        if (grid[x][y] == 2) {
            if (Integer.bitCount(vis) == cnt) {
                ans++;
            }
            return;
        }
        for (int[] d : new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) {
            int nx = x + d[0], ny = y + d[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
               continue;
            }
            if (grid[nx][ny] == -1 || (vis >> (nx * n + ny) & 1) == 1) {
                continue;
            }
            dfs(nx, ny, vis | (1 << (nx * n + ny)));
        }
    }

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        cnt = 0;
        ans = 0;
        int x = 0, y = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0;j < n; j++) {
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
                if (grid[i][j] != -1) {
                    cnt++;
                }
            }
        }
        dfs(x, y, 1 << (x * n + y));
        return ans;
    }
}