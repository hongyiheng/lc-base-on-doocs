class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        if grid[0][0]:
            return -1
        m, n = len(grid), len(grid[0])
        q = deque([[0, 0]])
        vis = [[False] * n for _ in range(m)]
        vis[0][0] = True
        dirs = [[0, 1], [0, -1], [-1, -1], [-1, 0], [-1, 1], [1, -1], [1, 0], [1, 1]]
        ans = 1
        while q:
            for _ in range(len(q)):
                x, y = q.popleft()
                if x == m - 1 and y == n - 1:
                    return ans
                for d in dirs:
                    nx, ny = x + d[0], y + d[1]
                    if nx < 0 or nx >= m or ny < 0 or ny >= n:
                        continue
                    if grid[nx][ny] or vis[nx][ny]:
                        continue
                    q.append([nx, ny])
                    vis[nx][ny] = True
            ans += 1
        return -1
