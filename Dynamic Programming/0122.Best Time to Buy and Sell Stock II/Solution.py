class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        f0, f1 = 0, -prices[0]
        for i in range(1, n):
            tmp = f0
            f0 = max(f0, f1 + prices[i])
            f1 = max(f1, tmp - prices[i])
        return max(f0, f1)