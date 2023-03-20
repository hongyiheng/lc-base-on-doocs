class Solution:
    def sumOfDistancesInTree(self, n: int, edges: List[List[int]]) -> List[int]:
        g = defaultdict(list)
        for u, v in edges:
            g[u].append(v)
            g[v].append(u)
        cnt, depth = [0] * n, [0] * n

        def dfs(u, p):
            nonlocal g, cnt, depth
            cnt[u] = 1
            if not g[u]:
                return
            for v in g[u]:
                if v == p:
                    continue
                depth[v] = depth[u] + 1
                dfs(v, u)
                cnt[u] += cnt[v]

        dfs(0, -1)
        ans = [0] * n
        ans[0] = sum(depth)

        def dfs2(u, p):
            nonlocal g, cnt, ans, n
            for v in g[u]:
                if v == p:
                    continue
                ans[v] = ans[u] + (n - cnt[v]) - cnt[v]
                dfs2(v, u)

        dfs2(0, -1)
        return ans
