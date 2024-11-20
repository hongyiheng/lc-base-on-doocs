class Solution:
    def shortestDistanceAfterQueries(self, n: int, queries: List[List[int]]) -> List[int]:
        def bfs():
            q = deque([0])
            vis = [False] * n
            vis[0] = True
            d = 0
            while q:
                for _ in range(len(q)):
                    u = q.popleft()
                    if u == n - 1:
                        return d
                    for v in g[u]:
                        if not vis[v]:
                            vis[v] = True
                            q.append(v)
                d += 1

        g = [[i + 1] for i in range(n - 1)]
        ans = []
        for u, v in queries:
            g[u].append(v)
            ans.append(bfs())
        return ans

