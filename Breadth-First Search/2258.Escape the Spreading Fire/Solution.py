class Solution:
    def maximumMinutes(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        f = []
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    f.append([i, j])
        dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]

        def infect(g, q):
            nonlocal grid, m, n, dirs
            ans = []
            while q:
                x, y = q.pop()
                g[x][y] = True
                for d in dirs:
                    nx, ny = x + d[0], y + d[1]
                    if nx < 0 or nx >= m or ny < 0 or ny >= n:
                        continue
                    if g[nx][ny] or grid[nx][ny] == 2:
                        continue
                    g[nx][ny] = True
                    ans.append([nx, ny])
            return ans

        def check(x):
            nonlocal f, grid, dirs, m, n
            cur_fire = f[:]
            fire = [[False] * n for _ in range(m)]
            while x > 0:
                cur_fire = infect(fire, cur_fire)
                x -= 1
            if fire[0][0]:
                return False
            vis = [[False] * n for _ in range(m)]
            vis[0][0] = True
            q = deque()
            q.append([0, 0])
            while q:
                if fire[m - 1][n - 1]:
                    return False
                k = len(q)
                for _ in range(k):
                    x, y = q.popleft()
                    if fire[x][y]:
                        continue
                    for d in dirs:
                        nx, ny = x + d[0], y + d[1]
                        if nx < 0 or nx >= m or ny < 0 or ny >= n:
                            continue
                        if vis[nx][ny] or fire[nx][ny] or grid[nx][ny] == 2:
                            continue
                        if nx == m - 1 and ny == n - 1:
                            return True
                        vis[nx][ny] = True
                        q.append([nx, ny])
                cur_fire = infect(fire, cur_fire)
            return False

        left, right = 0, m * n
        while left < right:
            mid = (left + right + 1) >> 1
            if check(mid):
                left = mid
            else:
                right = mid - 1
        if left == m * n:
            return int(1e9)
        return left if check(left) else -1


