class Solution:
    def countOfPairs(self, n: int, x: int, y: int) -> List[int]:
        g = [[inf] * n for _ in range(n)]
        for i in range(n - 1):
            g[i][i + 1] = 1
            g[i + 1][i] = 1
        g[x - 1][y - 1] = g[y - 1][x - 1] = 1
        for k in range(n):
            for i in range(n):
                for j in range(i + 1, n):
                    g[j][i] = g[i][j] = min(g[i][j], g[i][k] + g[k][j])
        ans = [0] * n
        for i in range(n):
            for j in range(i + 1, n):
                v = g[i][j]
                if v == inf:
                    continue
                ans[v - 1] += 2
        return ans