class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] f = new int[n][2 * k];
        for (int i = 0; i < k; i++) {
            f[0][i * 2 + 1] = -prices[0];
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            f[i][1] = Math.max(f[i - 1][1], -prices[i]);
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1] + prices[i]);
            ans = Math.max(ans, f[i][0]);
            for (int j = 1; j < k; j++) {
                f[i][j * 2 + 1] = Math.max(f[i - 1][j * 2 + 1], f[i][j * 2 - 2] - prices[i]);
                f[i][j * 2] = Math.max(f[i - 1][j * 2], f[i][j * 2 + 1] + prices[i]);
                ans = Math.max(ans, f[i][j * 2]);
            }
        }
        return ans;
    }
}