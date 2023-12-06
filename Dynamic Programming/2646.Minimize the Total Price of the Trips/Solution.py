class Solution:
    def minimumTotalPrice(self, n: int, edges: List[List[int]], price: List[int], trips: List[List[int]]) -> int:
        def dfs(u, p, t):
            if u == t:
                cnt[u] += 1
                return True
            for v in g[u]:
                if v == p:
                    continue
                if dfs(v, u, t):
                    cnt[u] += 1
                    return True
            return False

        def f(u, p):
            c = cnt[u] * price[u]
            hc = c // 2
            for v in g[u]:
                if v == p:
                    continue
                nc, nhc = f(v, u)
                c += min(nc, nhc)
                hc += nc
            return (c, hc)

        g = defaultdict(list)
        for u, v in edges:
            g[u].append(v)
            g[v].append(u)
        cnt = [0] * n
        for u, v in trips:
            dfs(u, -1, v)
        return min(f(0, -1))