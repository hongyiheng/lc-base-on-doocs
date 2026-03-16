class Solution:
    def getBiggestThree(self, grid: List[List[int]]) -> List[int]:
        def getS(i, j, d):
            if d == 0:
                return grid[i][j]
            s = grid[i - d][j] + grid[i + d][j] + grid[i][j - d] + grid[i][j + d]
            for k in range(1, d):
                l, r = j - d + k, j + d - k
                s += grid[i + k][l] + grid[i + k][r] + grid[i - k][l] + grid[i - k][r]
            return s

        ans = []
        vis = set()
        m, n = len(grid), len(grid[0])
        for d in range((min(m, n) + 1) // 2):
            for i in range(m):
                if i - d < 0 or i + d >= m:
                    continue
                for j in range(n):
                    if j - d < 0 or j + d >= n:
                        continue
                    s = getS(i, j, d)
                    if s in vis:
                        continue
                    vis.add(s)
                    heapq.heappush(ans, s)
                    if len(ans) > 3:
                        heapq.heappop(ans)
        return sorted(ans, reverse=True)