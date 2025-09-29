class Solution:
    def minScoreTriangulation(self, values: List[int]) -> int:
        n = len(values)
        f = [[0] * n for _ in range(n)]
        for l in range(2, n):
            for i in range(n):
                j = i + l
                if j >= n:
                    continue
                v = 0x3f3f3f3f
                for k in range(i + 1, j):
                    v = min(v, f[i][k] + f[k][j] + values[i] * values[j] * values[k])
                f[i][j] = v
        return f[0][n - 1]

