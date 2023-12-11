class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        m, n = len(heights), len(heights[0])
        q = [[0, 0, 0]]
        f = [[inf] * n for _ in range(m)]
        f[0][0] = 0
        while q:
            w, x, y = heapq.heappop(q)
            if w != f[x][y]:
                continue
            for d in [[0, 1], [1, 0], [-1, 0], [0, -1]]:
                nx, ny = x + d[0], y + d[1]
                if nx < 0 or nx >= m or ny < 0 or ny >= n:
                    continue
                nw = max(w, abs(heights[nx][ny] - heights[x][y]))
                if f[nx][ny] > nw:
                    f[nx][ny] = nw
                    heapq.heappush(q, [nw, nx, ny])
        return f[m - 1][n - 1]