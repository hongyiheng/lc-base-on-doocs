class Solution:
    def minPathCost(self, grid: List[List[int]], moveCost: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        f = [[inf] * n for _ in range(m)]
        for j in range(n):
            f[0][j] = grid[0][j]
        for i in range(m - 1):
            for j in range(n):
                v = grid[i][j]
                for k in range(n):
                    f[i + 1][k] = min(f[i + 1][k], f[i][j] + moveCost[v][k] + grid[i + 1][k])
        return min(f[m - 1])