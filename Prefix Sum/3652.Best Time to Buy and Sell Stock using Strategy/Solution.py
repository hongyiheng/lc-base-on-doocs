class Solution:
    def maxProfit(self, prices: List[int], strategy: List[int], k: int) -> int:
        n = len(prices)
        pre = [0] * (n + 1)
        ps = [0] * (n + 1)
        for i in range(n):
            pre[i + 1] = pre[i] + prices[i] * strategy[i]
            ps[i + 1] = ps[i] + prices[i]
        ans = pre[-1]
        for i in range(k, n + 1):
            v = pre[n] - pre[i] + pre[i - k] + ps[i] - ps[i - k // 2]
            ans = max(ans, v)
        return ans