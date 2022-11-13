class Solution {
    public int numTilings(int n) {
        int mod = (int)1e9 + 7;
        long[][] dp = new long[n + 5][4];
        dp[0][0] = dp[0][3] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][3];
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
            for (int j = 0; j < 4; j++) {
                dp[i][3] += dp[i - 1][j];
                dp[i][3] %= mod;
            }
        }
        return (int) dp[n - 1][3];
    }
}
