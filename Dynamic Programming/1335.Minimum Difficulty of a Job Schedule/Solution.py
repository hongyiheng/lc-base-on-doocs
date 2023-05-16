class Solution:
    def minDifficulty(self, jobDifficulty: List[int], d: int) -> int:
        n = len(jobDifficulty)
        f = [[inf] * (d + 1) for _ in range(n + 1)]
        f[0][0] = 0
        for i in range(1, n + 1):
            for j in range(1, d + 1):
                x = 0
                for k in range(i - 1, -1, -1):
                    x = max(x, jobDifficulty[k])
                    f[i][j] = min(f[i][j], f[k][j - 1] + x)
        return -1 if f[n][d] >= inf else f[n][d]
