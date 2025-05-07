class Solution:
    def minTimeToReach(self, moveTime: List[List[int]]) -> int:
        m, n = len(moveTime), len(moveTime[0])
        q = [(0, 0, 0)]
        step = [[inf] * n for _ in range(m)]
        step[0][0] = 0
        while q:
            w, x, y = heapq.heappop(q)
            if x == m - 1 and y == n - 1:
                return w
            for d in [[0, 1], [1, 0], [-1, 0], [0, -1]]:
                nx, ny = x + d[0], y + d[1]
                if nx < 0 or nx >= m or ny < 0 or ny >= n:
                    continue
                nw = max(moveTime[nx][ny] + 1, w + 1)
                if step[nx][ny] <= nw:
                    continue
                step[nx][ny] = nw
                heapq.heappush(q, (nw, nx, ny))
        return -1


