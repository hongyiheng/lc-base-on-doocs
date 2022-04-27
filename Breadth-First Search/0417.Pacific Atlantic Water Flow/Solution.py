class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        m, n = len(heights), len(heights[0])
        pacific = [[False] * n for _ in range(m)]
        atlantic = [[False] * n for _ in range(m)]
        pacific_queue = []
        atlantic_queue = []
        for i in range(m):
            for j in range(n):
                if i == 0 or j == 0:
                    pacific[i][j] = True
                    pacific_queue.append([i, j])
                if i == m - 1 or j == n - 1:
                    atlantic[i][j] = True
                    atlantic_queue.append([i, j])

        def bfs(res, q):
            dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
            while q:
                x, y = q.pop()
                for d in dirs:
                    nx, ny = x + d[0], y + d[1]
                    if nx < 0 or nx >= m or ny < 0 or ny >= n:
                        continue
                    if res[nx][ny] or heights[nx][ny] < heights[x][y]:
                        continue
                    res[nx][ny] = True
                    q.append([nx, ny])

        bfs(pacific, pacific_queue)
        bfs(atlantic, atlantic_queue)
        ans = []
        for i in range(m):
            for j in range(n):
                if pacific[i][j] and atlantic[i][j]:
                    ans.append([i, j])
        return ans
