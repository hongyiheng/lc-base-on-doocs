class Solution:
    def lastStoneWeightII(self, stones: List[int]) -> int:
        s, n = sum(stones), len(stones)
        t = s // 2
        dp = [[0] * (t + 1) for _ in range(n + 1)]
        for i in range(1, n + 1):
            for j in range(t + 1):
                dp[i][j] = dp[i - 1][j]
                v = stones[i - 1]
                if j >= v:
                    dp[i][j] = max(dp[i][j], dp[i - 1][j - v] + v)
        return abs(s - dp[n][t] - dp[n][t])
