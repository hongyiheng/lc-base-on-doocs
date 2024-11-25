class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        g = [[inf] * (n + 1) for _ in range(n + 1)]
        for u, v, w in times:
            g[u][v] = w
        dist = [inf] * (n + 1)
        dist[k] = 0
        q = [[0, k]]
        while q:
            w, u = heapq.heappop(q)
            for v in range(len(g[u])):
                if g[u][v] == inf:
                    continue
                if w + g[u][v] >= dist[v]:
                    continue
                dist[v] = w + g[u][v]
                heapq.heappush(q, [dist[v], v])
        ans = max(dist[1:])
        return -1 if ans == inf else ans

