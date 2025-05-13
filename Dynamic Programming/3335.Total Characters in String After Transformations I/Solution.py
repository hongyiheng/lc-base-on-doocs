class Solution:
    def lengthAfterTransformations(self, s: str, t: int) -> int:
        f = [[0] * 26 for _ in range(t + 1)]
        for c in s:
            f[0][ord(c) - ord('a')] += 1
        for i in range(t):
            f[i + 1][0] = f[i][25]
            f[i + 1][1] = f[i][25] + f[i][0]
            for j in range(2, 26):
                f[i + 1][j] = f[i][j - 1]
        return sum(f[t]) % int(1e9 + 7)
