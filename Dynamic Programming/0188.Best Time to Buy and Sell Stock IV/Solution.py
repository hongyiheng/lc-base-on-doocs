class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        n = len(prices)
        f = [[0] * (2 * k) for _ in range(n)]
        for i in range(k):
            f[0][i * 2 + 1] = -prices[0]
        ans = 0
        for i in range(1, n):
            f[i][0] = max(f[i - 1][0], f[i - 1][1] + prices[i])
            f[i][1] = max(f[i - 1][1], -prices[i])
            for j in range(1, k):
                f[i][j * 2] = max(f[i - 1][j * 2], f[i - 1][j * 2 + 1] + prices[i])
                f[i][j * 2 + 1] = max(f[i - 1][j * 2 + 1], f[i][j * 2 - 2] - prices[i])
            ans = max(ans, max(f[i]))
        return ans
