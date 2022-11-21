class Solution:
    def soupServings(self, n: int) -> float:
        if n >= 5000:
            return 1
        n = (n + 24) // 25
        dp = [[0] * (n + 1) for _ in range(n + 1)]
        dp[0][0] = 0.5
        for j in range(1, n + 1):
            dp[0][j] = 1
        for i in range(1, n + 1):
            for j in range(1, n + 1):
                dp[i][j] = dp[max(i - 4, 0)][j]
                dp[i][j] += dp[max(i - 3, 0)][j - 1]
                dp[i][j] += dp[max(i - 2, 0)][max(j - 2, 0)]
                dp[i][j] += dp[i - 1][max(j - 3, 0)]
                dp[i][j] *= 0.25
        return dp[n][n]
