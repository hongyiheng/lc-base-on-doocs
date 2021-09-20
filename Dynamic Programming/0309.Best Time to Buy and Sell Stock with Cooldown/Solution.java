class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][3];
        dp[0][0] = 0;
        dp[0][1] = prices[0] * -1;
        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i - 1][1] + prices[i];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][0]);
        }
        return Math.max(dp[len - 1][0], dp[len - 1][2]);
    }
}