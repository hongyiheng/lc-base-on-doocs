class Solution:
    def valueAfterKSeconds(self, n: int, k: int) -> int:
        mod = int(1e9 + 7)
        f = [[0] * n for _ in range(k + 1)]
        f[0][0] = 1
        for i in range(k + 1):
            for j in range(n):
                if i:
                    f[i][j] = f[i - 1][j]
                if j:
                    f[i][j] = (f[i][j] + f[i][j - 1]) % mod
        return f[k][n - 1]