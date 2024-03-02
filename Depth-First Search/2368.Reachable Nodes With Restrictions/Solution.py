class Solution:
    def reachableNodes(self, n: int, edges: List[List[int]], restricted: List[int]) -> int:
        def dfs(u, p):
            ans = 0
            for v in g[u]:
                if v == p or v in s:
                    continue
                ans += dfs(v, u)
            return ans + 1

        s = set(restricted)
        if 0 in s:
            return 0
        g = defaultdict(list)
        for u, v in edges:
            g[u].append(v)
            g[v].append(u)
        return dfs(0, -1)