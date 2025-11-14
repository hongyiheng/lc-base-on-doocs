class Solution:
    def rangeAddQueries(self, n: int, queries: List[List[int]]) -> List[List[int]]:
        g = [[0] * n for _ in range(n)]
        for x1, y1, x2, y2 in queries:
            for x in range(x1, x2 + 1):
                g[x][y1] += 1
                if y2 < n - 1:
                    g[x][y2 + 1] -= 1
        for i in range(n):
            s = 0
            for j in range(n):
                s += g[i][j]
                g[i][j] = s
        return g
