class Solution:
    def maxKDivisibleComponents(self, n: int, edges: List[List[int]], values: List[int], k: int) -> int:
        @cache
        def dfs(u, p):
            ans = 0
            s = values[u]
            for v in g[u]:
                if v == p:
                    continue
                n_ans, ns = dfs(v, u)
                ans += n_ans
                s += ns
            if not s % k:
                ans += 1
            return [ans, s % k]

        g = defaultdict(list)
        for u, v in edges:
            g[u].append(v)
            g[v].append(u)
        return dfs(0, -1)[0]