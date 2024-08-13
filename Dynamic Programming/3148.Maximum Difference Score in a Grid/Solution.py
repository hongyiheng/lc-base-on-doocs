class Solution:
    def maxScore(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        f = [[inf] * (n + 1) for _ in range(m + 1)]
        ans = -inf
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                mi = min(f[i][j - 1], f[i - 1][j])
                ans = max(ans, grid[i - 1][j - 1] - mi)
                f[i][j] = min(mi, grid[i - 1][j - 1])
        return ans