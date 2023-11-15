class Solution:
    def maxProfit(self, prices: List[int], fee: int) -> int:
        f0, f1 = 0, -prices[0]
        for i in range(1, len(prices)):
            t = f0
            f0 = max(f0, f1 + prices[i] - fee)
            f1 = max(f1, t - prices[i])
        return max(f0, f1)