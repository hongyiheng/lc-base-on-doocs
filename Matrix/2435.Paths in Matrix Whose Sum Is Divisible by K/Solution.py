class Solution:
    def numberOfPaths(self, grid: List[List[int]], k: int) -> int:
        mod = int(1e9 + 7)
        m, n = len(grid), len(grid[0])
        dp = [[[0] * k for _ in range(n)] for _ in range(m)]
        dp[0][0][grid[0][0] % k] = 1
        for i in range(m):
            for j in range(n):
                v = grid[i][j]
                for q in range(k):
                    if i:
                        dp[i][j][q] += dp[i - 1][j][(q - v) % k]
                    if j:
                        dp[i][j][q] += dp[i][j - 1][(q - v) % k]
        return dp[-1][-1][0] % mod
