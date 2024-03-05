class Solution:
    def countPaths(self, n: int, roads: List[List[int]]) -> int:
        MOD = int(1e9) + 7
        g = [[inf] * n for _ in range(n)]
        for u, v, w in roads:
            g[u][v] = g[v][u] = w
        dist = [inf] * n
        dist[0] = 0
        f = [0] * n
        f[0] = 1
        q = [(0, 0)]
        while q:
            w, u = heapq.heappop(q)
            if u == n - 1:
                return f[-1]
            if w > dist[u]:
                continue
            for v, d in enumerate(g[u]):
                nw = w + d
                if nw < dist[v]:
                    dist[v] = nw
                    f[v] = f[u]
                    heapq.heappush(q, (nw, v))
                elif nw == dist[v]:
                    f[v] = (f[u] + f[v]) % MOD
        return f[-1]
