class Solution:
    def minTrioDegree(self, n: int, edges: List[List[int]]) -> int:
        g = defaultdict(set)
        for u, v in edges:
            g[u].add(v)
            g[v].add(u)
        ans = inf
        for i in range(1, n + 1):
            for j in range(i + 1, n + 1):
                if j not in g[i]:
                    continue
                for k in range(j + 1, n + 1):
                    if k not in g[j] or i not in g[k]:
                        continue
                    ans = min(ans, len(g[i]) + len(g[j]) + len(g[k]) - 6)
        return -1 if ans == inf else ans