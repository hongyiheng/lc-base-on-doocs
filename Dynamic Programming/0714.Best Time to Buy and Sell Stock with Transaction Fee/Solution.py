class Solution:
    def maxProfit(self, prices: List[int], fee: int) -> int:
        n = len(prices)
        f = [[0] * 2 for _ in range(n)]
        f[0][1] = -prices[0]
        for i in range(1, n):
            f[i][1] = max(f[i - 1][1], f[i - 1][0] - prices[i])
            f[i][0] = max(f[i - 1][0], f[i - 1][1] + prices[i] - fee)
        return max(f[n - 1])