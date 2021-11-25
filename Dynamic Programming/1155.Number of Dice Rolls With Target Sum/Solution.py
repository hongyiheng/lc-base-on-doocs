class Solution:
    def numRollsToTarget(self, d: int, f: int, target: int) -> int:
        mod = int(1e9 + 7)
        dp = [[0 for _ in range(target + 1)] for _ in range(d + 1)]
        dp[0][0] = 1
        for i in range(1, d + 1):
            for j in range(target + 1):
                for v in range(1, f + 1):
                    if (j >= v):
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - v]) % mod
        return dp[d][target]