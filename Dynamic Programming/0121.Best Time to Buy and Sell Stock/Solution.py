class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        last_min, ans = float('inf'), 0
        for v in prices:
            ans = max(ans, v - last_min)
            last_min = min(last_min, v)
        return ans