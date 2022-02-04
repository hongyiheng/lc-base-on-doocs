class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        q = deque()
        m, n, count = len(grid), len(grid[0]), 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    q.append([i, j])
                if grid[i][j] == 1:
                    count += 1
        ans = 0
        while q and count > 0:
            ans += 1
            k = len(q)
            for i in range(k):
                cur = q.popleft()
                for d in dirs:
                    nx, ny = cur[0] + d[0], cur[1] + d[1]
                    if nx < 0 or nx >= m or ny < 0 or ny >= n:
                        continue
                    if grid[nx][ny] == 1:
                        grid[nx][ny] = 2
                        count -= 1
                        q.append([nx, ny])
        return ans if count == 0 else -1

