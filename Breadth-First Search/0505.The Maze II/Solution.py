class Solution:
    def shortestDistance(self, maze: List[List[int]], start: List[int], destination: List[int]) -> int:
        m, n = len(maze), len(maze[0])
        dis = [[float('inf')] * n for _ in range(m)]
        q = deque()
        q.append(start)
        dis[start[0]][start[1]] = 0
        dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        while q:
            cur = q.popleft()
            for d in dirs:
                nx, ny = cur[0] + d[0], cur[1] + d[1]
                step = 0
                while 0 <= nx < m and 0 <= ny < n and maze[nx][ny] == 0:
                    nx += d[0]
                    ny += d[1]
                    step += 1
                nx -= d[0]
                ny -= d[1]
                if dis[cur[0]][cur[1]] + step < dis[nx][ny]:
                    dis[nx][ny] = dis[cur[0]][cur[1]] + step
                    q.append([nx, ny])
        return dis[destination[0]][destination[1]] if dis[destination[0]][destination[1]] != float('inf') else -1