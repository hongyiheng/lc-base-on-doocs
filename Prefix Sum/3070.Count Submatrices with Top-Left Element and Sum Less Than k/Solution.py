class Solution:
    def countSubmatrices(self, grid: List[List[int]], k: int) -> int:
        m, n = len(grid), len(grid[0])
        ans = 0
        for i in range(m):
            for j in range(n):
                if i:
                    grid[i][j] += grid[i - 1][j]
                if j:
                    grid[i][j] += grid[i][j - 1]
                if i and j:
                    grid[i][j] -= grid[i - 1][j - 1]
                if grid[i][j] <= k:
                    ans += 1
        return ans