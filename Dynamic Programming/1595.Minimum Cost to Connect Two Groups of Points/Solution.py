class Solution:
    def connectTwoGroups(self, cost: List[List[int]]) -> int:
        @cache
        def dfs(j, mask) -> int:
            if j == n:
                return sum(rmi[i] for i in range(m) if mask >> i & 1 == 0)
            res = inf
            for i in range(m):
                res = min(res, dfs(j + 1, mask | (1 << i)) + cost[i][j])
            return res

        m, n = len(cost), len(cost[0])
        rmi = [min(r) for r in cost]
        return dfs(0, 0)
