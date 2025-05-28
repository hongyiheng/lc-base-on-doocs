class Solution:
    def maxTargetNodes(self, edges1: List[List[int]], edges2: List[List[int]], k: int) -> List[int]:
        def build(edge):
            g = defaultdict(list)
            for u, v in edge:
                g[u].append(v)
                g[v].append(u)
            return g

        def dfs(g, u, p, d):
            if d < 0:
                return 0
            ans = 1
            for v in g[u]:
                if v == p:
                    continue
                ans += dfs(g, v, u, d - 1)
            return ans

        n, m = len(edges1), len(edges2)
        g1, g2 = build(edges1), build(edges2)
        mx = max([dfs(g2, i, -1, k - 1) for i in range(m + 1)])
        return [dfs(g1, i, -1, k) + mx for i in range(n + 1)]

