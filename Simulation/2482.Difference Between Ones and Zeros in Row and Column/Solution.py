class Solution:
    def onesMinusZeros(self, grid: List[List[int]]) -> List[List[int]]:
        n, m = len(grid), len(grid[0])
        row, col = [[0] * 2 for _ in range(n)], [[0] * 2 for _ in range(m)]
        for i in range(n):
            for j in range(m):
                row[i][grid[i][j]] += 1
                col[j][grid[i][j]] += 1
        diff = [[0] * m for _ in range(n)]
        for i in range(n):
            for j in range(m):
                diff[i][j] = row[i][1] + col[j][1] - row[i][0] - col[j][0]
        return diff
