class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        m, n = len(matrix), len(matrix[0])
        dis = [[float('inf')] * n for _ in range(m)]
        dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]

        def search(a, b):
            nonlocal m, n, matrix, dis
            dis[a][b] = 1 if dis[a][b] == float('inf') else dis[a][b]
            q = deque()
            q.append([a, b])
            ans = 1
            while q:
                x, y = q.popleft()
                for d in dirs:
                    nx, ny = x + d[0], y + d[1]
                    if nx < 0 or nx >= m or ny < 0 or ny >= n:
                        continue
                    if matrix[nx][ny] <= matrix[x][y]:
                        continue
                    if dis[nx][ny] == float('inf') or dis[nx][ny] < dis[x][y] + 1:
                        dis[nx][ny] = dis[x][y] + 1
                        ans = max(ans, dis[nx][ny])
                        q.append([nx, ny])
            return ans

        ans = 0
        for i in range(m):
            for j in range(n):
                ans = max(ans, search(i, j))
        return ans