class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        m, n, t = len(s1), len(s2), len(s3)
        if m + n != t:
            return False
        f = [[False] * (n + 1) for _ in range(m + 1)]
        f[0][0] = True
        for i in range(1, m + 1):
            if f[i - 1][0] and s3[i - 1] == s1[i - 1]:
                f[i][0] = True
        for j in range(1, n + 1):
            if f[0][j - 1] and s3[j - 1] == s2[j - 1]:
                f[0][j] = True
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                c = s3[i + j - 1]
                if f[i - 1][j] and s1[i - 1] == c:
                    f[i][j] = True
                if f[i][j - 1] and s2[j - 1] == c:
                    f[i][j] = True
        return f[m][n]