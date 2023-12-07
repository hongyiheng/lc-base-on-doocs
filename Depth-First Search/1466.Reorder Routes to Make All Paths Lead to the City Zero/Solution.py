class Solution:
    def minReorder(self, n: int, connections: List[List[int]]) -> int:
        def dfs(u, p):
            ans = 0
            for v, w in g[u]:
                if v == p:
                    continue
                ans += w + dfs(v, u)
            return ans

        g = defaultdict(list)
        for u, v in connections:
            g[u].append([v, 1])
            g[v].append([u, 0])
        return dfs(0, -1)