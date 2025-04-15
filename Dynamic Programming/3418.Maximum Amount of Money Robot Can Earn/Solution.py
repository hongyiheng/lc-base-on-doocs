class Solution:
    def maximumAmount(self, coins: List[List[int]]) -> int:
        m, n = len(coins), len(coins[0])
        f = [[[-inf] * 3 for _ in range(n + 1)] for _ in range(m + 1)]
        f[1][0] = [0] * 3
        for i, row in enumerate(coins):
            for j, x in enumerate(row):
                f[i + 1][j + 1][0] = max(f[i + 1][j][0], f[i][j + 1][0]) + x
                f[i + 1][j + 1][1] = max(f[i + 1][j][1] + x, f[i][j + 1][1] + x, f[i + 1][j][0], f[i][j + 1][0])
                f[i + 1][j + 1][2] = max(f[i + 1][j][2] + x, f[i][j + 1][2] + x, f[i + 1][j][1], f[i][j + 1][1])
        return f[m][n][2]
                

