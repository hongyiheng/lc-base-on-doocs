class Solution:
    def largest1BorderedSquare(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        row = [[0] * n for _ in range(m)]
        col = [[0] * n for _ in range(m)]
        for i in range(m - 1, -1, -1):
            for j in range(n -1, -1, -1):
                if grid[i][j]:
                    row[i][j] = 1 if j == n - 1 else row[i][j + 1] + 1
                    col[i][j] = 1 if i == m - 1 else col[i + 1][j] + 1
        ans = 0
        for i in range(m):
            for j in range(n):
                for k in range(ans, min(m - i, n - j)):
                    if i + k >= m or j + k >= n:
                        continue
                    if row[i][j] > k and col[i][j] > k and row[i + k][j] > k and col[i][j + k] > k:
                        ans = max(ans, k + 1)
        return ans * ans