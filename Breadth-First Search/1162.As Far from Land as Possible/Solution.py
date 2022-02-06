class Solution:
    def maxDistance(self, grid: List[List[int]]) -> int:
        q = deque()
        m, n = len(grid), len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    q.append([i, j])
        ans = -1
        dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        while q:
            k = len(q)
            for i in range(k):
                cur = q.popleft()
                x, y = cur[0], cur[1]
                for d in dirs:
                    nx, ny = x + d[0], y + d[1]
                    if nx < 0 or nx >= m or ny < 0 or ny >= n or grid[nx][ny] != 0:
                        continue
                    grid[nx][ny] = grid[x][y] + 1
                    ans = max(grid[nx][ny] - 1, ans)
                    q.append([nx, ny])
        return ans