class Solution:
    def rearrangeSticks(self, n: int, k: int) -> int:
        mod = int(1e9 + 7)
        f = [[0] * (k + 1) for _ in range(n + 1)]
        f[0][0] = 1
        for i in range(1, n + 1):
            for j in range(1, k + 1):
                f[i][j] = f[i - 1][j - 1]
                if i - 1 >= j:
                    f[i][j] = (f[i][j] + (i - 1) * f[i - 1][j]) % mod
        return f[n][k]
