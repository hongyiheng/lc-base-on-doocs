class Solution:
    def minSteps(self, n: int) -> int:
        def dfs(s, d):
            if s + d == n:
                return 1
            if s + d > n:
                return inf
            return min(dfs(s + d, d) + 1, dfs(s + s, s) + 2)

        if n <= 1:
            return 0
        return dfs(1, 1) + 1