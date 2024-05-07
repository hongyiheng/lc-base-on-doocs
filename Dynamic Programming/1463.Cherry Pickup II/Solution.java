class Solution {

    int m, n;
    int[][][] f;

    public int dfs(int x, int j1, int j2, int[][] grid) {
        if (j1 < 0 || j1 >= n || j2 < 0 || j2 >= n) {
            return 0;
        }
        if (f[x][j1][j2] != -1) {
            return f[x][j1][j2];
        }
        int ans = grid[x][j1] + (j1 != j2 ? grid[x][j2] : 0);
        if (x == m - 1) {
            return ans;
        }
        int v = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                v = Math.max(v, dfs(x + 1, j1 + i, j2 + j, grid));
            }
        }
        f[x][j1][j2] = ans + v;
        return ans + v;
    }

    public int cherryPickup(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        f = new int[m][n][n];
        for (int[][] g : f) {
            for (int[] row : g) {
                Arrays.fill(row, -1);
            }
        }
        return dfs(0, 0, n - 1, grid);
    }
}