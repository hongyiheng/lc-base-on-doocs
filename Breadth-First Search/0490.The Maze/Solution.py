class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        m, n = len(maze), len(maze[0])
        vis = [[False] * n for _ in range(m)]
        q = deque()
        q.append(start)
        vis[start[0]][start[1]] = True
        dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        while q:
            cur = q.popleft()
            for d in dirs:
                nx, ny = cur[0] + d[0], cur[1] + d[1]
                while 0 <= nx < m and 0 <= ny < n and maze[nx][ny] == 0:
                    nx += d[0]
                    ny += d[1]
                nx -= d[0]
                ny -= d[1]
                if vis[nx][ny]:
                    continue
                vis[nx][ny] = True
                q.append([nx, ny])
        return vis[destination[0]][destination[1]]