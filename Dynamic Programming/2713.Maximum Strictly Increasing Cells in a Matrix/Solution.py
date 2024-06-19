class Solution:
    def maxIncreasingCells(self, mat: List[List[int]]) -> int:
        m, n = len(mat), len(mat[0])
        g = defaultdict(list)
        for i in range(m):
            for j in range(n):
                g[mat[i][j]].append((i, j))
        row_max = [0] * m
        col_max = [0] * n
        ans = 0
        for pos in g.values():
            k = len(pos)
            f = [0] * k
            for i in range(k):
                x, y = pos[i]
                f[i] = max(row_max[x], col_max[y]) + 1
                ans = max(ans, f[i])
            for i in range(k):
                x, y = pos[i]
                row_max[x] = max(row_max[x], f[i])
                col_max[y] = max(col_max[y], f[i])
        return ans
