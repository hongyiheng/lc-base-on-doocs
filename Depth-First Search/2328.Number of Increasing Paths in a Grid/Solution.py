class Solution:
    def countPaths(self, grid: List[List[int]]) -> int:
        mod = int(1e9 + 7)
        m, n = len(grid), len(grid[0])

        @cache
        def dfs(x, y):
            cnt = 1
            for d in [[0, 1], [1, 0], [-1, 0], [0, -1]]:
                nx, ny = x + d[0], y + d[1]
                if nx < 0 or nx >= m or ny < 0 or ny >= n:
                    continue
                if grid[nx][ny] > grid[x][y]:
                    cnt += dfs(nx, ny)
            return cnt

        ans = 0
        for i in range(m):
            for j in range(n):
                ans += dfs(i, j)
        return ans % mod