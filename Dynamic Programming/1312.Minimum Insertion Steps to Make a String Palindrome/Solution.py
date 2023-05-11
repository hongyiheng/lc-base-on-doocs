class Solution:
    def minInsertions(self, s: str) -> int:
        n = len(s)
        f = [[0] * n for _ in range(n)]
        for i in range(1, n):
            f[i - 1][i] = 0 if s[i - 1] == s[i] else 1
        for L in range(3, n + 1):
            for l in range(0, n):
                r = l + L - 1
                if r >= n:
                    break
                if s[l] == s[r]:
                    f[l][r] = f[l + 1][r - 1]
                else:
                    f[l][r] = min(f[l + 1][r], f[l][r - 1]) + 1
        return f[0][n - 1]
