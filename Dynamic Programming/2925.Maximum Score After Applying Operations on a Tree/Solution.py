class Solution:
    def maximumScoreAfterOperations(self, edges: List[List[int]], values: List[int]) -> int:
        def dfs(u, p):
            if len(g[u]) == 1:
                return values[u]
            s = 0
            for v in g[u]:
                if v == p:
                    continue
                s += dfs(v, u)
            return min(values[u], s)

        g = defaultdict(list)
        g[0].append(-1)
        for u, v in edges:
            g[u].append(v)
            g[v].append(u)
        return sum(values) - dfs(0, -1)