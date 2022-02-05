class Solution:
    def getMaximumGold(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        vis = [[False] * n for _ in range(m)]

        def dfs(x, y):
            if grid[x][y] == 0 or vis[x][y]:
                return 0
            vis[x][y] = True
            ans = 0
            for d in dirs:
                nx, ny = x + d[0], y + d[1]
                if nx < 0 or nx >= m or ny < 0 or ny >= n:
                    continue
                if grid[nx][ny] == 0 or vis[nx][ny]:
                    continue
                ans = max(ans, dfs(nx, ny))
            vis[x][y] = False
            return grid[x][y] + ans

        ans = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] != 0:
                    ans = max(ans, dfs(i, j))
        return ans