class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        m, n = len(matrix), len(matrix[0])
        for i in range(1, m):
            for j in range(n):
                v = matrix[i - 1][j]
                if j > 0:
                    v = min(v, matrix[i - 1][j - 1])
                if j < n - 1:
                    v = min(v, matrix[i - 1][j + 1])
                matrix[i][j] += v
        return min(matrix[m - 1])