class Solution:
    def maximumDetonation(self, bombs: List[List[int]]) -> int:
        def dfs(u, r):
            nonlocal n
            ans = 1
            for v in range(n):
                if v in vis or r * r < g[u][v]:
                    continue
                vis.add(v)
                ans += dfs(v, bombs[v][2])
            return ans

        n = len(bombs)
        g = [[inf] * n for _ in range(n)]
        for i in range(n):
            for j in range(i + 1, n):
                x = bombs[i][0] - bombs[j][0]
                y = bombs[i][1] - bombs[j][1]
                g[i][j] = g[j][i] = x * x + y * y
        ans = 0
        for i in range(n):
            vis = {i}
            ans = max(ans, dfs(i, bombs[i][2]))
        return ans
