class Solution:
    def countPairsOfConnectableServers(self, edges: List[List[int]], signalSpeed: int) -> List[int]:
        def dfs(u, p, w):
            ans = 0 if w % signalSpeed else 1
            for v, vw in g[u]:
                if v != p:
                    ans += dfs(v, u, vw + w)
            return ans

        g = defaultdict(list)
        for u, v, w in edges:
            g[u].append([v, w])
            g[v].append([u, w])
        n = len(edges)
        ans = [0] * (n + 1)
        for u in range(n + 1):
            s = 0
            for v, w in g[u]:
                t = dfs(v, u, w)
                ans[u] += s * t
                s += t
        return ans
