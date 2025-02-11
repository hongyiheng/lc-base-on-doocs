class Solution {
    public int countPathsWithXorValue(int[][] grid, int x) {
        int mod = (int)1e9 + 7;
        int m = grid.length, n = grid[0].length;
        int[][][] f = new int[m][n][16];
        f[0][0][grid[0][0]] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 16; k++) {
                    int t = grid[i][j] ^ k;
                    if (i > 0) {
                        f[i][j][k] = (f[i][j][k] + f[i - 1][j][t]) % mod;
                    }
                    if (j > 0) {
                        f[i][j][k] = (f[i][j][k] + f[i][j - 1][t]) % mod;
                    }
                }
            }
        }
        return f[m - 1][n - 1][x];
    }
}