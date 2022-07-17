class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        dp = [[0] * (n + 1) for _ in range(k + 1)]
        for i in range(1, k + 1):
            for j in range(1, n + 1):
                dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1] + 1
        for j in range(1, n + 1):
            if dp[k][j] >= n:
                return j
        return -1