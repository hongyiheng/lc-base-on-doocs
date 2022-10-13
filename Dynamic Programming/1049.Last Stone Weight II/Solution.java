class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length, s = 0;
        for (int v : stones) {
            s += v;
        }
        int t = s / 2;
        int[][] dp = new int[n + 1][t + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < t + 1; j++) {
                int v = stones[i - 1];
                dp[i][j] = dp[i - 1][j];
                if (j >= v) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v] + v);
                }
            }
        }
        return Math.abs(s - dp[n][t] - dp[n][t]);
    }
}
