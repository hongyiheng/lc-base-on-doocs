class Solution:
    def maxValueOfCoins(self, piles: List[List[int]], k: int) -> int:
        n = len(piles)
        f = [[0] * (k + 1) for _ in range(n + 1)]
        for i, p in enumerate(piles):
            for j in range(k + 1):
                f[i + 1][j] = f[i][j]
                s = 0
                for x in range(min(len(p), j)):
                    s += p[x]
                    f[i + 1][j] = max(f[i + 1][j], f[i][j - x - 1] + s)
        return f[n][k]