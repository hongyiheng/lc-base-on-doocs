class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m, n = len(mat), len(mat[0])
        ans = [[float('inf')] * n for _ in range(m)]
        vis = [[False] * n for _ in range(m)]
        q = deque()
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append([i, j])
                    vis[i][j] = True
        step = 0
        dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        while q:
            k = len(q)
            for _ in range(k):
                x, y = q.popleft()
                ans[x][y] = step
                for d in dirs:
                    nx, ny = x + d[0], y + d[1]
                    if nx < 0 or nx >= m or ny < 0 or ny >= n:
                        continue
                    if vis[nx][ny]:
                        continue
                    q.append([nx, ny])
                    vis[nx][ny] = True
            step += 1
        return ans