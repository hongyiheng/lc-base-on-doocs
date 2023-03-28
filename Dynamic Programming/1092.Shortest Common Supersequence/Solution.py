class Solution:
    def shortestCommonSupersequence(self, s: str, t: str) -> str:
        m, n = len(s), len(t)
        f = [[0] * (n + 1) for _ in range(m + 1)]
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if s[i - 1] == t[j - 1]:
                    f[i][j] = f[i - 1][j - 1] + 1
                else:
                    f[i][j] = max(f[i - 1][j], f[i][j - 1])
        ans = ""
        i, j = m, n
        while i > 0 and j > 0:
            if s[i - 1] == t[j - 1]:
                ans += s[i - 1]
                i -= 1
                j -= 1
            elif f[i - 1][j] > f[i][j - 1]:
                ans += s[i - 1]
                i -= 1
            else:
                ans += t[j - 1]
                j -= 1
        while i > 0:
            ans += s[i - 1]
            i -= 1
        while j > 0:
            ans += t[j - 1]
            j -= 1
        return ans[::-1]