class Solution:
    def countSubgraphsForEachDiameter(self, n: int, edges: List[List[int]]) -> List[int]:
        def dfs(u):
            nonlocal vis, mask, d
            vis |= 1 << u
            ans = 0
            for v in g[u]:
                if (vis >> v & 1) == 0 and mask >> v & 1:
                    nx = dfs(v) + 1
                    d = max(d, ans + nx)
                    ans = max(ans, nx)
            return ans

        g = defaultdict(list)
        for u, v in edges:
            u -= 1
            v -= 1
            g[u].append(v)
            g[v].append(u)
        ans = [0] * (n - 1)
        for mask in range(1, 1 << n):
            if mask & (mask - 1) == 0:
                continue
            vis = d = 0
            dfs(mask.bit_length() - 1)
            if vis == mask:
                ans[d - 1] += 1
        return ans