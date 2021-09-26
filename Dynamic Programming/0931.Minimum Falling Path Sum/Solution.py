class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        row = len(matrix)
        col = len(matrix[0])
        if col == 1:
            return matrix[0][0]
        dp = [[101 for i in range(col)] for j in range(row)]
        for i in range(row):
            for j in range(col):
                if i == 0:
                    dp[i][j] = matrix[i][j]
                    continue
                if j == 0:
                    dp[i][j] = min(dp[i - 1][j], dp[i - 1][j + 1]) + matrix[i][j]
                elif j == col - 1:
                    dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - 1]) + matrix[i][j]
                else:
                    dp[i][j] = min(min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i - 1][j + 1]) + matrix[i][j]

        ans = sys.maxsize
        for i in range(col):
            ans = min(dp[row - 1][i], ans)
        return ans