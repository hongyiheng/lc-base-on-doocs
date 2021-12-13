class Solution:
    def maxIncreaseKeepingSkyline(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        rows, cols = [0] * m, [0] * n
        for i in range(m):
            rows[i] = max(grid[i])
        for j in range(n):
            high = 0
            for i in range(m):
                high = max(high, grid[i][j])
            cols[j] = high
        res = 0
        for i in range(m):
            for j in range(n):
                max_high = min(rows[i], cols[j])
                res += max_high - grid[i][j]
        return res