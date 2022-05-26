class Solution:
    def cutOffTree(self, forest: List[List[int]]) -> int:
        def get_f(a, b, c, d, g):
            return abs(a - c) + abs(c - d) + g

        def astar_search(a, b, c, d):
            q = []
            heapq.heappush(q, [get_f(a, b, c, d, 0), a, b])
            dis = [[float('inf')] * n for _ in range(m)]
            dis[a][b] = 0
            dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
            while q:
                _, x, y = heapq.heappop(q)
                g = dis[x][y]
                if x == c and y == d:
                    return g
                for dir in dirs:
                    nx, ny = x + dir[0], y + dir[1]
                    if nx < 0 or nx >= m or ny < 0 or ny >= n or forest[nx][ny] == 0:
                        continue
                    if dis[nx][ny] <= g + 1:
                        continue
                    dis[nx][ny] = g + 1
                    heapq.heappush(q, [get_f(nx, ny, c, d, dis[nx][ny]), nx, ny])
            return -1

        m, n = len(forest), len(forest[0])
        q = []
        for i in range(m):
            for j in range(n):
                if forest[i][j] > 1:
                    heapq.heappush(q, [forest[i][j], i, j])
        x, y = 0, 0
        ans = 0
        while q:
            _, nx, ny = heapq.heappop(q)
            dis = astar_search(x, y, nx, ny)
            if dis == -1:
                return -1
            x, y = nx, ny
            ans += dis
        return ans