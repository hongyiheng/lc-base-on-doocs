class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int mod = (int)1e9 + 7;
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][k];
        dp[0][0][grid[0][0] % k] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int q = 0; q < k; q++) {
                    if (i > 0) {
                        dp[i][j][q] += dp[i - 1][j][(q - grid[i][j] + 100 * k) % k];
                        dp[i][j][q] = dp[i][j][q] % mod;
                    }
                    if (j > 0) {
                        dp[i][j][q] += dp[i][j - 1][(q - grid[i][j] + 100 * k) % k];
                        dp[i][j][q] = dp[i][j][q] % mod;
                    }
                }
            }
        }
        return dp[m - 1][n - 1][0] % mod;
    }
}
