class Solution:
    def getAncestors(self, n: int, edges: List[List[int]]) -> List[List[int]]:
        def bfs(x):
            q = deque([x])
            vis = {x}
            while q:
                u = q.popleft()
                for v in g[u]:
                    if v in vis:
                        continue
                    vis.add(v)
                    q.append(v)
                    ans[v].append(x)

        g = defaultdict(list)
        for u, v in edges:
            g[u].append(v)
        ans = [[] for _ in range(n)]
        for i in range(n):
            bfs(i)
        return ans