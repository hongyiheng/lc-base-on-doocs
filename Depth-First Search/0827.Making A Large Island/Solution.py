class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        n = len(grid)
        dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]

        def dfs(x, y, v):
            if grid[x][y] != 1:
                return 0
            grid[x][y] = v
            ans = 1
            for d in dirs:
                nx, ny = x + d[0], y + d[1]
                if nx < 0 or nx >= n or ny < 0 or ny >= n:
                    continue
                if grid[nx][ny] == 1:
                    ans += dfs(nx, ny, v)
            return ans

        mp = dict()
        ans, group = 0, 2
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 1:
                    mp[group] = dfs(i, j, group)
                    ans = max(ans, mp[group])
                    group += 1
        for i in range(n):
            for j in range(n):
                if grid[i][j] != 0:
                    continue
                cur = 1
                used = {0, 1}
                for d in dirs:
                    nx, ny = i + d[0], j + d[1]
                    if nx < 0 or nx >= n or ny < 0 or ny >= n:
                        continue
                    if grid[nx][ny] in used:
                        continue
                    cur += mp[grid[nx][ny]]
                    used.add(grid[nx][ny])
                ans = max(ans, cur)
        return ans