class Solution:
    def numWays(self, n: int, k: int) -> int:
        dp = [[0] * 2 for _ in range(n)]
        dp[0][0] = 0
        dp[0][1] = k
        for i in range(1, n):
            dp[i][0] = dp[i - 1][1]
            dp[i][1] = dp[i - 1][0] * (k - 1) + dp[i - 1][1] * (k - 1)
        return dp[n - 1][0] + dp[n - 1][1]