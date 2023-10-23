class Solution:
    def findShortestCycle(self, n: int, edges: List[List[int]]) -> int:
        g = defaultdict(list)
        for u, v in edges:
            g[u].append(v)
            g[v].append(u)
        ans = n + 1
        for i in range(n):
            dis = [-1] * n
            dis[i] = 0
            q = deque([(i, -1)])
            while q:
                u, p = q.popleft()
                for v in g[u]:
                    if dis[v] < 0:
                        dis[v] = dis[u] + 1
                        q.append((v, u))
                    elif v != p:
                        ans = min(ans, dis[u] + dis[v] + 1)
        return ans if ans <= n else -1
