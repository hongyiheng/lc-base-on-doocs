class Solution:
    def countVowelStrings(self, n: int) -> int:
        f = [[0] * 5 for _ in range(n)]
        for i in range(5):
            f[0][i] = 1
        for i in range(1, n):
            for j in range(5):
                for k in range(j + 1):
                    f[i][j] += f[i - 1][k]
        ans = 0
        for i in range(5):
            ans += f[n - 1][i]
        return ans