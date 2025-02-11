class Solution:
    def countPathsWithXorValue(self, grid: List[List[int]], x: int) -> int:
        m, n = len(grid), len(grid[0])
        f = [[[0] * 16 for _ in range(n)] for _ in range(m)]
        f[0][0][grid[0][0]] = 1
        for i in range(m):
            for j in range(n):
                for k in range(16):
                    t = grid[i][j] ^ k
                    if i:
                        f[i][j][k] += f[i - 1][j][t]
                    if j:
                        f[i][j][k] += f[i][j - 1][t]
        return f[m - 1][n - 1][x] % int(1e9 + 7)