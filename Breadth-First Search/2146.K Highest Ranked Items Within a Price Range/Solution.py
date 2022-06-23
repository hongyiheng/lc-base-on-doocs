class Solution:
    def highestRankedKItems(self, grid: List[List[int]], pricing: List[int], start: List[int], k: int) -> List[List[int]]:
        m, n = len(grid), len(grid[0])
        vis = [[False] * n for _ in range(m)]
        dirs = [[-1, 0], [0, -1], [0, 1], [1, 0]]
        q = []
        q.append(start)
        vis[start[0]][start[1]] = True
        ans = []
        while q and len(ans) < k:
            tmp = q[:]
            tmp.sort(key=lambda x: (-grid[x[0]][x[1]], -x[0], -x[1]))
            l = len(tmp)
            q = []
            for _ in range(l):
                x, y = tmp.pop()
                if pricing[0] <= grid[x][y] <= pricing[1]:
                    ans.append([x, y])
                    if len(ans) == k:
                        break
                for d in dirs:
                    nx, ny = x + d[0], y + d[1]
                    if nx < 0 or nx >= m or ny < 0 or ny >= n:
                        continue
                    if grid[nx][ny] == 0 or vis[nx][ny]:
                        continue
                    vis[nx][ny] = True
                    q.append([nx, ny])
        return ans