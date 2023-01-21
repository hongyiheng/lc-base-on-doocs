class Solution:
    def minSideJumps(self, obstacles: List[int]) -> int:
        n = len(obstacles)
        dp = [[0] * 3 for _ in range(n)]
        dp[0][0] = dp[0][2] = 1
        for i in range(1, n):
            if obstacles[i] != 0:
                dp[i][obstacles[i] - 1] = dp[i - 1][obstacles[i] - 1] = float('inf')
            if dp[i][0] == 0:
                dp[i][0] = min(dp[i - 1][0], min(dp[i - 1][1], dp[i - 1][2]) + 1)
            if dp[i][1] == 0:
                dp[i][1] = min(dp[i - 1][1], min(dp[i - 1][0], dp[i - 1][2]) + 1)
            if dp[i][2] == 0:
                dp[i][2] = min(dp[i - 1][2], min(dp[i - 1][0], dp[i - 1][1]) + 1)
        return min(dp[n - 1])