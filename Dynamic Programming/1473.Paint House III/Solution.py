class Solution:
    def minCost(self, houses: List[int], cost: List[List[int]], m: int, n: int, t: int) -> int:
        INF = 0x3f3f3f3f
        f = [[[0] * (t + 1) for _ in range(n + 1)] for _ in range(m + 1)]
        for i in range(m + 1):
            for j in range(n + 1):
                f[i][j][0] = INF
        for i in range(1, m + 1):
            color = houses[i - 1]
            for j in range(1, n + 1):
                for k in range(1, t + 1):
                    if k > i:
                        f[i][j][k] = INF
                        continue
                    if color:
                        if j == color:
                            tmp = INF
                            for p in range(1, n + 1):
                                if j != p:
                                    tmp = min(tmp, f[i - 1][p][k - 1])
                            f[i][j][k] = min(tmp, f[i - 1][j][k])
                        else:
                            f[i][j][k] = INF
                    else:
                        u = cost[i - 1][j - 1]
                        tmp = INF
                        for p in range(1, n + 1):
                            if j != p:
                                tmp = min(tmp, f[i - 1][p][k - 1])
                        f[i][j][k] = min(tmp, f[i - 1][j][k]) + u
        ans = INF
        for i in range(1, n + 1):
            ans = min(ans, f[m][i][t])
        return -1 if ans == INF else ans