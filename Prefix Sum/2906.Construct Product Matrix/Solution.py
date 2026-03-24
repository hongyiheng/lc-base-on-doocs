class Solution:
    def constructProductMatrix(self, grid: List[List[int]]) -> List[List[int]]:
        @cache
        def dfs(pre, pos):
            nonlocal m, n, mod
            i, j = pos // n, pos % n
            if i >= m:
                return 1
            tail = dfs(pre * grid[i][j] % mod, pos + 1)
            ans[i][j] = pre * tail % mod
            return tail * grid[i][j] % mod

        mod = 12345
        m, n = len(grid), len(grid[0])
        ans = [[0] * n for _ in range(m)]
        dfs(1, 0)
        return ans
