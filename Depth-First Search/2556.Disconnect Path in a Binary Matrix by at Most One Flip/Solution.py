class Solution:
    def isPossibleToCutPath(self, grid: List[List[int]]) -> bool:
        def dfs(x, y):
            if x == m - 1 and y == n - 1:
                return True
            grid[x][y] = 0
            ans = False
            for d in [[0, 1], [1, 0]]:
                nx, ny = x + d[0], y + d[1]
                if nx < 0 or nx >= m or ny < 0 or ny >= n:
                    continue
                if not grid[nx][ny]:
                    continue
                ans = ans or dfs(nx, ny)
            return ans

        m, n = len(grid), len(grid[0])
        if not grid[0][0] or not grid[m - 1][n - 1]:
            return True
        return not dfs(0, 0) or not dfs(0, 0)