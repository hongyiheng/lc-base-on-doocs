class Solution:
    def cherryPickup(self, grid: List[List[int]]) -> int:
        @cache
        def dfs(t, j1, j2):
            nonlocal n
            if j1 >= n or j2 >= n or t - j1 >= n or t - j2 >= n or grid[t - j1][j1] == -1 or grid[t - j2][j2] == -1:
                return -inf
            if t == (n - 1) * 2:
                return grid[-1][-1]
            ans = grid[t - j1][j1] + (grid[t - j2][j2] if j1 != j2 else 0)
            ans += max(dfs(t + 1, j1, j2), dfs(t + 1, j1, j2 + 1), dfs(t + 1, j1 + 1, j2), dfs(t + 1, j1 + 1, j2 + 1))
            return ans

        n = len(grid)
        return max(dfs(0, 0, 0), 0)