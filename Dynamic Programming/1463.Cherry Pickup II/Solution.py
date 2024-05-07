class Solution:
    def cherryPickup(self, grid: List[List[int]]) -> int:
        @cache
        def dfs(x, j1, j2):
            nonlocal m, n
            if j1 < 0 or j1 >= n or j2 < 0 or j2 >= n:
                return 0
            ans = grid[x][j1] + (grid[x][j2] if j1 != j2 else 0)
            if x == m - 1:
                return ans
            v = 0
            for i in range(-1, 2):
                for j in range(-1, 2):
                    v = max(v, dfs(x + 1, j1 - i, j2 - j))
            return ans + v

        m, n = len(grid), len(grid[0])
        return dfs(0, 0, n - 1)