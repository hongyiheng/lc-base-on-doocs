class Solution:
    def countGoodNodes(self, edges: List[List[int]]) -> int:
        def dfs(u, p):
            nonlocal ans
            cnt, t = 1, 0
            for v in g[u]:
                if v == p:
                    continue
                cnt += 1
                nv = dfs(v, u)
                if not t or t == nv:
                    t = nv
                else:
                    t = -1
                cnt += nv
            if t != -1:
                ans += 1
            return cnt

        g = defaultdict(list)
        for u, v in edges:
            g[u].append(v)
            g[v].append(u)
        ans = 0
        dfs(0, -1)
        return ans