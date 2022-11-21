class Solution {
    public double soupServings(int n) {
        if (n >= 5000) {
            return 1;
        }
        n = (n + 24) / 25;
        double[][] dp = new double[n + 1][n + 1];
        dp[0][0] = 0.5;
        for (int j = 1; j < n + 1; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] += dp[Math.max(0, i - 4)][j];
                dp[i][j] += dp[Math.max(0, i - 3)][j - 1];
                dp[i][j] += dp[Math.max(0, i - 2)][Math.max(0, j - 2)];
                dp[i][j] += dp[i - 1][Math.max(0, j - 3)];
                dp[i][j] *= 0.25;
            }
        }
        return dp[n][n];
    }
}
