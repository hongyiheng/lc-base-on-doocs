class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        f = [[inf] * n for _ in range(m)]
        f[0][0] = grid[0][0]
        q = [[grid[0][0], 0, 0]]
        while q:
            for i in range(len(q)):
                w, x, y = heapq.heappop(q)
                for d in [[1, 0], [0, 1], [-1, 0], [0, -1]]:
                    nx, ny = x + d[0], y + d[1]
                    if nx < 0 or nx >= m or ny < 0 or ny >= n:
                        continue
                    nw = max(grid[nx][ny], w)
                    if f[nx][ny] <= nw:
                        continue
                    f[nx][ny] = nw
                    heapq.heappush(q, [nw, nx, ny])
        return f[-1][-1]

