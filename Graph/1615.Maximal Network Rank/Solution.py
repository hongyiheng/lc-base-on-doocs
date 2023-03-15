class Solution:
    def maximalNetworkRank(self, n: int, roads: List[List[int]]) -> int:
        g = [set() for _ in range(n)]
        for u, v in roads:
            g[u].add(v)
            g[v].add(u)
        ans = 0
        for i in range(n):
            for j in range(i + 1, n):
                v = len(g[i]) + len(g[j])
                if i in g[j]:
                    v -= 1
                ans = max(ans, v)
        return ans