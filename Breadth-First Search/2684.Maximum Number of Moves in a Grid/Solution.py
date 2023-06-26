class Solution:
    def maxMoves(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        q = deque([[x, 0, grid[x][0]] for x in range(m)])
        vis = [[False] * n for _ in range(m)]
        ans = 0
        while q:
            for _ in range(len(q)):
                x, y, v = q.popleft()
                for d in range(-1, 2):
                    nx, ny = x + d, y + 1
                    if nx < 0 or nx >= m or ny < 0 or ny >= n:
                        continue
                    if vis[nx][ny] or grid[nx][ny] <= v:
                        continue
                    vis[nx][ny] = True
                    q.append([nx, ny, grid[nx][ny]])
            if q:
                ans += 1
        return ans