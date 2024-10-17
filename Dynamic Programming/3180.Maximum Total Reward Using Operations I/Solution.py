class Solution:
    def maxTotalReward(self, rewardValues: List[int]) -> int:
        rewardValues.sort()
        n, m = len(rewardValues), 4000
        f = [[False] * m for _ in range(n + 1)]
        f[0][0] = True
        for i, v in enumerate(rewardValues, 1):
            for j in range(m):
                f[i][j] = f[i - 1][j] or (v <= j < 2 * v and f[i - 1][j - v])
        for i in range(m - 1, -1, -1):
            if f[n][i]:
                return i
        return 0
