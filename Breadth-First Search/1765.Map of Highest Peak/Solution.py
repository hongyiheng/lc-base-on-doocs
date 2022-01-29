class Solution:
    def highestPeak(self, isWater: List[List[int]]) -> List[List[int]]:
        m, n = len(isWater), len(isWater[0])
        ans = [[0] * n for _ in range(m)]
        q = deque()
        for i in range(m):
            for j in range(n):
                ans[i][j] = -1
                if isWater[i][j] == 1:
                    ans[i][j] = 0
                    q.append([i, j])
        dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        while q:
            cur = q.popleft()
            x, y = cur[0], cur[1]
            for d in dirs:
                nx, ny = x + d[0], y + d[1]
                if nx < 0 or nx >= m or ny < 0 or ny >= n:
                    continue
                if ans[nx][ny] != -1:
                    continue
                ans[nx][ny] = ans[x][y] + 1
                q.append([nx, ny])
        return ans