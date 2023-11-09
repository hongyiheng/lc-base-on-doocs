class Solution:
    def maximumMinutes(self, grid: List[List[int]]) -> int:
        def check(k):
            vis = set()
            q = deque(fires[::])
            p = deque([[0, 0]])
            while p:
                if q:
                    for _ in range(len(q)):
                        x, y = q.popleft()
                        if x == m - 1 and y == n - 1:
                            return False
                        for d in dirs:
                            nx, ny = x + d[0], y + d[1]
                            if nx < 0 or nx >= m or ny < 0 or ny >= n:
                                continue
                            if (nx, ny) in vis or grid[nx][ny] != 0:
                                continue
                            q.append([nx, ny])
                            vis.add((nx, ny))
                if k <= 0:
                    for _ in range(len(p)):
                        x, y = p.popleft()
                        for d in dirs:
                            nx, ny = x + d[0], y + d[1]
                            if nx < 0 or nx >= m or ny < 0 or ny >= n:
                                continue
                            if nx == m - 1 and ny == n - 1:
                                return True
                            if (nx, ny) in vis or grid[nx][ny] != 0:
                                continue
                            p.append([nx, ny])
                            vis.add((nx, ny))
                k -= 1
            return False

        m, n = len(grid), len(grid[0])
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        fires = []
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    fires.append([i, j])
        if not check(0):
            return -1
        l, r = 0, m * n + 1
        while l < r:
            mid = (l + r + 1) >> 1
            if check(mid):
                l = mid
            else:
                r = mid - 1
        return int(1e9) if r > m * n else r