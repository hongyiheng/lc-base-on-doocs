class Solution:
    def shortestBridge(self, grid: List[List[int]]) -> int:
        dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        n = len(grid)
        q = deque()

        def dfs(x, y):
            if grid[x][y] != 1:
                return
            q.append((x, y))
            grid[x][y] = 2
            for d in dirs:
                nx, ny = x + d[0], y + d[1]
                if nx < 0 or nx >= n or ny < 0 or ny >= n:
                    continue
                dfs(nx, ny)

        for i in range(n):
            end = False
            for j in range(n):
                if grid[i][j] == 1:
                    dfs(i, j)
                    end = True
                    break
            if end:
                break
        ans = 0
        while q:
            m = len(q)
            for _ in range(m):
                x, y = q.popleft()
                for d in dirs:
                    nx, ny = x + d[0], y + d[1]
                    if nx < 0 or nx >= n or ny < 0 or ny >= n:
                        continue
                    if grid[nx][ny] == 1:
                        return ans
                    if grid[nx][ny] == 0:
                        grid[nx][ny] = 2
                        q.append((nx, ny))
            ans += 1
        return ans
