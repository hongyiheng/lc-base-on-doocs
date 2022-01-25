class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        dp = [[0] * 4 for _ in range(n + 1)]
        dp[0][0] = -prices[0]
        dp[0][2] = -prices[0]
        for i in range(1, n + 1):
            dp[i][0] = max(dp[i - 1][0], -prices[i - 1])
            dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] + prices[i - 1])
            dp[i][2] = max(dp[i - 1][2], dp[i - 1][1] - prices[i - 1])
            dp[i][3] = max(dp[i - 1][3], dp[i - 1][2] + prices[i - 1])
        ans = 0
        for i in range(4):
            ans = max(max(max(dp[n][0], dp[n][1]), dp[n][2]), dp[n][3])
        return ans