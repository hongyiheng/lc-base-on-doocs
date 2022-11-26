class Solution:
    def reachableNodes(self, edges: List[List[int]], maxMoves: int, n: int) -> int:
        def dijkstra():
            dist[0] = 0
            q = [[0, 0]]
            while q:
                u = heapq.heappop(q)[1]
                for v, w in mp[u]:
                    if dist[v] > (t := dist[u] + w):
                        dist[v] = t
                        heapq.heappush(q, [t, v])

        dist = [0x3f3f3f3f] * n
        mp = defaultdict(list)
        for u, v, w in edges:
            mp[u].append((v, w + 1))
            mp[v].append((u, w + 1))
        dijkstra()
        ans = sum(v <= maxMoves for v in dist)
        for e in edges:
            l, r = max(maxMoves - dist[e[0]], 0), max(maxMoves - dist[e[1]], 0)
            ans += min(e[2], l + r)
        return ans
