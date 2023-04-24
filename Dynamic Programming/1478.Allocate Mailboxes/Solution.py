class Solution:
    def minDistance(self, houses: List[int], k: int) -> int:
        n, inf = len(houses), 0x3f3f3f3f
        cost = [[0] * n for _ in range(n)]
        houses.sort()
        for i in range(n - 2, -1, -1):
            for j in range(i + 1, n):
                if j - i <= 2:
                    cost[i][j] = houses[j] - houses[i]
                else:
                    cost[i][j] = cost[i + 1][j - 1] + houses[j] - houses[i]
        f = [[0] * (k + 1) for _ in range(n)]
        for i in range(n):
            f[i][1] = cost[0][i]
        for i in range(n):
            for j in range(2, min(k + 1, i + 1)):
                f[i][j] = f[i][j - 1]
                for p in range(1, i + 1):
                    f[i][j] = min(f[i][j], f[i - p][j - 1] + cost[i - p + 1][i])
        return f[n - 1][k]
