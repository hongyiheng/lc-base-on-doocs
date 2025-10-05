class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        def dfs(x, y, v):
            nonlocal m, n
            dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
            for d in dirs:
                nx, ny = x + d[0], y + d[1]
                if nx < 0 or nx >= m or ny < 0 or ny >= n:
                    continue
                if f[nx][ny] & v == v or heights[nx][ny] < heights[x][y]:
                    continue
                f[nx][ny] |= v
                dfs(nx, ny, v)

        m, n = len(heights), len(heights[0])
        f = [[0] * n for _ in range(m)]
        for i in range(m):
            for j in range(n):
                v = 0
                if i == 0 or j == 0:
                    v |= 1
                if i == m - 1 or j == n - 1:
                    v |= 2
                if v:
                    f[i][j] |= v
                    dfs(i, j, v)
        return [[i, j] for i in range(m) for j in range(n) if f[i][j] == 3]
