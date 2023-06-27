class Solution:
    def minIncrements(self, n: int, cost: List[int]) -> int:
        ans = 0
        for i in range(n - 1, 0, -2):
            l, r = cost[i], cost[i - 1]
            ans += abs(l - r)
            cost[(i - 1) // 2] += max(l, r)
        return ans