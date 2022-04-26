class Solution:
    def projectionArea(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        row, col = [0] * m, [0] * n
        ans = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j]:
                    ans += 1
                row[i] = max(row[i], grid[i][j])
                col[j] = max(col[j], grid[i][j])
        return ans + sum(row) + sum(col)