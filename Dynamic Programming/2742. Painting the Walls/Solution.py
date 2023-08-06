class Solution:
    def paintWalls(self, cost: List[int], time: List[int]) -> int:
        @cache
        def dfs(i, t):
            nonlocal n
            if t >= n - i:
                return 0
            if i == n:
                return inf
            return min(dfs(i + 1, t + time[i]) + cost[i], dfs(i + 1, t - 1))

        n = len(cost)
        return dfs(0, 0)