class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        p = KMP(needle)
        return p.search(haystack)


class KMP:
    def __init__(self, pat):
        self.pat = pat
        m = len(pat)
        self.dp = [[0] * 256 for _ in range(m)]
        self.dp[0][ord(pat[0])] = 1
        x = 0
        for j in range(1, m):
            for c in range(256):
                if ord(pat[j]) == c:
                    self.dp[j][c] = j + 1
                else:
                    self.dp[j][c] = self.dp[x][c]
            x = self.dp[x][ord(pat[j])]

    def search(self, txt):
        m = len(self.pat)
        n = len(txt)
        j = 0
        for i in range(n):
            j = self.dp[j][ord(txt[i])]
            if j == m:
                return i - m + 1
        return -1