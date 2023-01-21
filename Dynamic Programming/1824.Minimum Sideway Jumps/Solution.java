class Solution {
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int[][] dp = new int[n][3];
        dp[0][0] = dp[0][2] = 1;
        for (int i = 1; i < n; i++) {
            if (obstacles[i] != 0) {
                dp[i - 1][obstacles[i] - 1] = dp[i][obstacles[i] - 1] = 0x3f3f3f;
            }
            if (dp[i][0] == 0) {
                dp[i][0] = Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], dp[i - 1][2]) + 1);
            }
            if (dp[i][1] == 0) {
                dp[i][1] = Math.min(dp[i - 1][1], Math.min(dp[i - 1][0], dp[i - 1][2]) + 1);
            }
            if (dp[i][2] == 0) {
                dp[i][2] = Math.min(dp[i - 1][2], Math.min(dp[i - 1][0], dp[i - 1][1]) + 1);
            }
        }
        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }
}