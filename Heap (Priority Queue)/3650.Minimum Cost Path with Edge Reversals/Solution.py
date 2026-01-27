class Solution:
    def minCost(self, n: int, edges: List[List[int]]) -> int:
        g = defaultdict(list)
        for u, v, w in edges:
            g[u].append([v, w])
            g[v].append([u, 2 * w])
        f = [inf] * n
        f[0] = 0
        q = [[0, 0]]
        while q:
            _, u = heapq.heappop(q)
            for v, w in g[u]:
                if f[v] > f[u] + w:
                    f[v] = f[u] + w
                    if f[v] > f[-1]:
                        continue
                    heapq.heappush(q, [f[v], v])
        return -1 if f[-1] == inf else f[-1]