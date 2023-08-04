class Solution:
    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        def dfs(x, y, vis):
            nonlocal m, n, cnt, ans
            if grid[x][y] == 2:
                if vis.bit_count() == cnt:
                    ans += 1
                return

            for d in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                nx, ny = x + d[0], y + d[1]
                if nx < 0 or nx >= m or ny < 0 or ny >= n:
                    continue
                if grid[nx][ny] == -1 or vis >> (nx * n + ny) & 1:
                    continue
                dfs(nx, ny, vis | 1 << (nx * n + ny))

        m, n = len(grid), len(grid[0])
        x = y = 0
        ans = cnt = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    x, y = i, j
                if grid[i][j] != -1:
                    cnt += 1
        dfs(x, y, 1 << (x * n + y))
        return ans