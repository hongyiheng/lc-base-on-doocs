class Solution:
    def numTilings(self, n: int) -> int:
        dp = [[0] * 4 for _ in range(n + 5)]
        dp[0][0] = dp[0][3] = 1
        for i in range(1, n):
            dp[i][0] = dp[i - 1][3]
            dp[i][1] = dp[i - 1][0] + dp[i - 1][2]
            dp[i][2] = dp[i - 1][0] + dp[i - 1][1]
            dp[i][3] = sum([dp[i - 1][j] for j in range(4)])
        return dp[n - 1][3] % int(1e9 + 7)
