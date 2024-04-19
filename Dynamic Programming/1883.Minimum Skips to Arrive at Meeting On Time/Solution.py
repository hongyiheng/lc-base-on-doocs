class Solution:
    def minSkips(self, dist: List[int], speed: int, hoursBefore: int) -> int:
        n = len(dist)
        f = [[inf] * n for _ in range(n + 1)]
        f[0][0] = 0
        for i in range(1, n + 1):
            d = dist[i - 1]
            for j in range(i + 1):
                if j < i:
                    f[i][j] = min(f[i][j], ceil(f[i - 1][j] + d / speed - 1e-9))
                if 0 < j < n:
                    f[i][j] = min(f[i][j], f[i - 1][j - 1] + d / speed)
        for i in range(n):
            if f[n][i] <= hoursBefore:
                return i
        return -1
