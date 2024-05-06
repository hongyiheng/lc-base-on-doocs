class Solution {

    int[][][] f;
    int n;

    public int dfs(int t, int j1, int j2, int[][] grid) {
        if (j1 >= n || j2 >= n || t - j1 >= n || t - j2 >= n || grid[t - j1][j1] == -1 || grid[t - j2][j2] == -1) {
            return -n * n;
        }
        if (t == (n - 1) * 2) {
            return grid[n - 1][n - 1];
        }
        if (f[t][j1][j2] != 0) {
            return f[t][j1][j2];
        }
        int ans = grid[t - j1][j1] + (j1 == j2 ? 0 : grid[t - j2][j2]);
        ans += Math.max(Math.max(dfs(t + 1, j1, j2, grid), dfs(t + 1, j1, j2 + 1, grid)),
                Math.max(dfs(t + 1, j1 + 1, j2, grid), dfs(t + 1, j1 + 1, j2 + 1, grid)));
        f[t][j1][j2] = ans;
        return ans;
    }

    public int cherryPickup(int[][] grid) {
        n = grid.length;
        f = new int[2 * n - 2][n][n];
        return Math.max(0, dfs(0, 0, 0, grid));
    }
}