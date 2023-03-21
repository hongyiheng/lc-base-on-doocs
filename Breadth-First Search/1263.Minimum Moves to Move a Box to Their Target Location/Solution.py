class Solution:
    def minPushBox(self, grid: List[List[str]]) -> int:
        def get_next(x, y, sx, sy):
            nonlocal m, n
            vis = {(sx, sy)}
            q = deque([[sx, sy]])
            while q:
                sx, sy = q.pop()
                for d in [[0, 1], [1, 0], [0, -1], [-1, 0]]:
                    nsx, nsy = sx + d[0], sy + d[1]
                    if nsx < 0 or nsx >= m or nsy < 0 or nsy >= n:
                        continue
                    if (nsx, nsy) in vis or grid[nsx][nsy] == "#":
                        continue
                    if nsx == x and nsy == y:
                        continue
                    vis.add((nsx, nsy))
                    q.append([nsx, nsy])

            pos = []
            if x - 1 >= 0 and x + 1 < m and grid[x - 1][y] != '#' and grid[x + 1][y] != '#':
                if (x - 1, y) in vis:
                    pos.append([x + 1, y, x, y])
                if (x + 1, y) in vis:
                    pos.append([x - 1, y, x, y])
            if y - 1 >= 0 and y + 1 < n and grid[x][y - 1] != '#' and grid[x][y + 1] != '#':
                if (x, y - 1) in vis:
                    pos.append([x, y + 1, x, y])
                if (x, y + 1) in vis:
                    pos.append([x, y - 1, x, y])
            return pos

        m, n = len(grid), len(grid[0])
        x = y = tx = ty = sx = sy = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 'B':
                    x = i
                    y = j
                if grid[i][j] == 'T':
                    tx = i
                    ty = j
                if grid[i][j] == 'S':
                    sx = i
                    sy = j

        vis = {(x, y, sx, sy)}
        q = deque([[x, y, sx, sy]])
        ans = 0
        while q:
            for _ in range(len(q)):
                x, y, sx, sy = q.popleft()
                if x == tx and y == ty:
                    return ans
                next_pos = get_next(x, y, sx, sy)
                for nx, ny, nsx, nsy in next_pos:
                    if (nx, ny, nsx, nsy) in vis:
                        continue
                    q.append([nx, ny, nsx, nsy])
                    vis.add((nx, ny, nsx, nsy))
            ans += 1
        return -1