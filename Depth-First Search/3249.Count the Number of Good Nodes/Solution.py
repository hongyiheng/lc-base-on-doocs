class Solution:
    def countGoodNodes(self, edges: List[List[int]]) -> int:
        def dfs(u, p):
            nonlocal ans
            t, s, cnt = -1, 1, 0
            for v in g[u]:
                if v == p:
                    continue
                cnt += 1
                nv = dfs(v, u)
                if t == -1:
                    t = nv
                elif t != nv:
                    t = -2
                s += nv
            if not cnt or t != -2:
                ans += 1
            return s

        g = defaultdict(list)
        for u, v in edges:
            g[u].append(v)
            g[v].append(u)
        ans = 0
        dfs(0, -1)
        return ans