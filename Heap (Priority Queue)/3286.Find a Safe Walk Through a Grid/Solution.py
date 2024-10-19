class Solution:
    def findSafeWalk(self, grid: List[List[int]], health: int) -> bool:
        m, n = len(grid), len(grid[0])
        f = [[inf] * n for _ in range(m)]
        f[0][0] = grid[0][0]
        q = [(grid[0][0], 0, 0)]
        while q:
            w, x, y = heapq.heappop(q)
            if x == m - 1 and y == n - 1:
                return w < health
            for d in [[0, 1], [1, 0], [-1, 0], [0, -1]]:
                nx, ny = x + d[0], y + d[1]
                if nx < 0 or nx >= m or ny < 0 or ny >= n:
                    continue
                if f[nx][ny] <= w + grid[nx][ny]:
                    continue
                f[nx][ny] = w + grid[nx][ny]
                heapq.heappush(q, (f[nx][ny], nx, ny))
        return False