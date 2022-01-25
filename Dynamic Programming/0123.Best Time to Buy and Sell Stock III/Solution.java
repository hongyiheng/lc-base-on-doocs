class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][4];
        int ans = 0;
        dp[0][0] = prices[0] * -1;
        dp[0][2] = prices[0] * -1;
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], prices[i - 1] * -1);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i - 1]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i - 1]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i - 1]);
        }
        for (int i = 0; i < 4; i++) {
            ans = ans = Math.max(Math.max(Math.max(dp[n][0], dp[n][1]), dp[n][2]), dp[n][3]);
        }
        return ans;
    }
}