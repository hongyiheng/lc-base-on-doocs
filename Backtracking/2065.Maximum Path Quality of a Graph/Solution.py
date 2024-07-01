class Solution:
    def maximalPathQuality(self, values: List[int], edges: List[List[int]], maxTime: int) -> int:
        def dfs(u, ts, vs):
            nonlocal ans
            if ts > maxTime:
                return
            if u == 0:
                ans = max(ans, vs)
            for v, t in g[u]:
                if vis[v]:
                    dfs(v, ts + t, vs)
                else:
                    vis[v] = True
                    dfs(v, ts + t, vs + values[v])
                    vis[v] = False

        n = len(values)
        g = defaultdict(list)
        for u, v, t in edges:
            g[u].append([v, t])
            g[v].append([u, t])
        vis = [False] * n
        vis[0] = True
        ans = 0
        dfs(0, 0, values[0])
        return ans