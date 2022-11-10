class Solution:
    def shortestPathAllKeys(self, grid: List[str]) -> int:
        n, m = len(grid), len(grid[0])
        q = deque()
        t = 0
        for i in range(n):
            for j in range(m):
                if grid[i][j] == '@':
                    q.append([i, j, 0])
                if 'a' <= grid[i][j] <= 'z':
                    t |= (1 << (ord(grid[i][j]) - ord('a')))
        vis = dict()
        w = 0
        while q:
            k = len(q)
            for _ in range(k):
                x, y, mask = q.popleft()
                for d in [[0, 1], [1, 0], [0, -1], [-1, 0]]:
                    nx, ny = x + d[0], y + d[1]
                    if nx < 0 or nx >= n or ny < 0 or ny >= m:
                        continue
                    if vis.get((nx, ny, mask), False) or grid[nx][ny] == '#':
                        continue
                    if 'A' <= grid[nx][ny] <= 'Z' and (1 << (ord(grid[nx][ny]) - ord('A'))) & mask == 0:
                        continue
                    vis[(nx, ny, mask)] = True
                    if 'a' <= grid[nx][ny] <= 'z':
                        next_mask = mask | (1 << (ord(grid[nx][ny]) - ord('a')))
                        if next_mask == t:
                            return w + 1
                        q.append([nx, ny, next_mask])
                        continue
                    q.append([nx, ny, mask])
            w += 1
        return -1
