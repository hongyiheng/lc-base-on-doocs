class Solution:
    def minCost(self, maxTime: int, edges: List[List[int]], passingFees: List[int]) -> int:
        n = len(passingFees)
        g = defaultdict(list)
        for u, v, t in edges:
            g[u].append([v, t])
            g[v].append([u, t])
        q = []
        heapq.heappush(q, [passingFees[0], 0, 0])
        ts = [inf] * n
        ts[0] = 0
        while q:
            d, t, u = heapq.heappop(q)
            for v, vt in g[u]:
                nd, nt = d + passingFees[v], t + vt
                if nt > maxTime or nt >= ts[v]:
                    continue
                ts[v] = nt
                if v == n - 1:
                    return nd
                heapq.heappush(q, [nd, nt, v])
        return -1
