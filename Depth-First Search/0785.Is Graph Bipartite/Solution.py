class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        def dfs(u):
            nonlocal a, b
            if u in vis:
                return True
            vis.add(u)
            p[u] = p[u] if p[u] else a
            for v in g[u]:
                p[v] = p[v] if p[v] else a + b - p[u]
                if p[u] == p[v] or not dfs(v):
                    return False
            return True

        g = defaultdict(list)
        for u, vs in enumerate(graph):
            for v in vs:
                g[u].append(v)
                g[v].append(u)

        a, b, n = 1, 2, len(graph)
        p = [0] * n
        vis = set()
        for i in range(n):
            if not dfs(i):
                return False
        return True
