class Solution:
    def modifiedGraphEdges(self, n: int, edges: List[List[int]], source: int, destination: int, target: int) -> List[List[int]]:
        def dijkstra(edges):
            g = [[inf] * n for _ in range(n)]
            for u, v, w in edges:
                if w == -1:
                    continue
                g[u][v] = g[v][u] = w
            dist = [inf] * n
            dist[source] = 0
            q = [(0, source)]
            while q:
                w, u = heapq.heappop(q)
                for v in range(n):
                    if w + g[u][v] < dist[v]:
                        dist[v] = w + g[u][v]
                        heapq.heappush(q, (dist[v], v))
            return dist[destination]

        inf = 2 * 10 ** 9
        d = dijkstra(edges)
        if d < target:
            return []
        ok = d == target
        for e in edges:
            if e[2] > 0:
                continue
            if ok:
                e[2] = inf
                continue
            e[2] = 1
            d = dijkstra(edges)
            if d <= target:
                ok = True
                e[2] += target - d
        return edges if ok else []