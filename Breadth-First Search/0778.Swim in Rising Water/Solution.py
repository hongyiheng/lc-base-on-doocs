class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        dirs = [[0, 1], [0, -1], [-1, 0], [1, 0]]
        n = len(grid)
        ans = [[0] * n for _ in range(n)]
        vis = [[False] * n for _ in range(n)]
        q = deque([[0, 0]])
        vis[0][0] = True
        ans[0][0] = grid[0][0]
        while q:
            x, y = q.pop()
            for d in dirs:
                nx, ny = x + d[0], y + d[1]
                if nx < 0 or nx >= n or ny < 0 or ny >= n:
                    continue
                w = max(ans[x][y], grid[nx][ny])
                if vis[nx][ny] and ans[nx][ny] <= w:
                    continue
                vis[nx][ny] = True
                ans[nx][ny] = w
                q.append([nx, ny])
        return ans[n - 1][n - 1]