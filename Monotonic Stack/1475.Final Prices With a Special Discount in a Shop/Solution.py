class Solution:
    def finalPrices(self, prices: List[int]) -> List[int]:
        n = len(prices)
        q = deque()
        ans = [0] * n
        for i in range(n - 1, -1, -1):
            cur = prices[i]
            while q and prices[q[0]] > prices[i]:
                q.popleft()
            if q:
                cur -= prices[q[0]]
            q.appendleft(i)
            ans[i] = cur
        return ans