class Solution:
    def maxSum(self, grid: List[List[int]]) -> int:
        ans, m, n = 0, len(grid), len(grid[0])
        for i in range(1, m - 1):
            for j in range(1, n - 1):
                cur = grid[i - 1][j - 1] + grid[i - 1][j] + grid[i - 1][j + 1] + grid[i][j] + grid[i + 1][j - 1] + grid[i + 1][j] + grid[i + 1][j + 1]
                ans = max(ans, cur)
        return ans
