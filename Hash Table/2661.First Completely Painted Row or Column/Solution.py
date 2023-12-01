class Solution:
    def firstCompleteIndex(self, arr: List[int], mat: List[List[int]]) -> int:
        m, n = len(mat), len(mat[0])
        g = dict()
        for i in range(m):
            for j in range(n):
                g[mat[i][j]] = (i, j)
        row, col = [0] * m, [0] * n
        for i, v in enumerate(arr):
            x, y = g[v]
            row[x] += 1
            col[y] += 1
            if row[x] == n or col[y] == m:
                return i
        return -1