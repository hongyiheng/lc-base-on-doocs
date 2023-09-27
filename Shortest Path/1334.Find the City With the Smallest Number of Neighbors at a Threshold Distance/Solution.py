class Solution:
    def findTheCity(self, n: int, edges: List[List[int]], distanceThreshold: int) -> int:
        g = [[inf] * n for _ in range(n)]
        for u, v, d in edges:
            g[u][v] = d
            g[v][u] = d
        for k in range(n):
            for i in range(n):
                if g[i][k] == inf:
                    continue
                for j in range(i + 1, n):
                    if i == j or g[k][j] == inf:
                        continue
                    g[i][j] = min(g[i][j], g[i][k] + g[k][j])
                    g[j][i] = g[i][j]
        ans, mi = 0, inf
        for i in range(n):
            cnt = 0
            for j in range(n):
                if g[i][j] <= distanceThreshold:
                    cnt += 1
            if cnt <= mi:
                mi = cnt
                ans = i
        return ans