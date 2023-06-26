class Solution:
    def maxMoves(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        f = [[inf] * n for _ in range(m)]
        for i in range(m):
            f[i][0] = grid[i][0]
        ans = 0
        for j in range(1, n):
            for i in range(m):
                v = f[i][j - 1]
                if i > 0:
                    v = min(v, f[i - 1][j - 1])
                if i < m - 1:
                    v = min(v, f[i + 1][j - 1])
                if grid[i][j] > v:
                    f[i][j] = grid[i][j]
                    ans = j
        return ans