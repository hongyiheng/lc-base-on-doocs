class Solution:
    def champagneTower(self, poured: int, query_row: int, query_glass: int) -> float:
        dp = [[0] * 100 for _ in range(100)]
        dp[0][0] = poured
        for i in range(1, 100):
            for j in range(99):
                if dp[i - 1][j]:
                    v = dp[i - 1][j] - 1
                    if v > 0:
                        dp[i][j] += v / 2
                        dp[i][j + 1] += v / 2
                        dp[i - 1][j] = 1
        return dp[query_row][query_glass]
