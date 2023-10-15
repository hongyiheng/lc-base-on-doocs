class Solution:
    def numberOfWays(self, n: int, x: int) -> int:
        f = [[0] * (n + 1) for _ in range(n + 1)]
        f[0][0] = 1
        for i in range(1, n + 1):
            if i ** x > n:
                continue
            for j in range(n + 1):
                f[i][j] = f[i - 1][j]
                if j >= i ** x:
                    f[i][j] += f[i - 1][j - i ** x]
        return max(f[i][n] for i in range(n + 1)) % int(1e9 + 7)