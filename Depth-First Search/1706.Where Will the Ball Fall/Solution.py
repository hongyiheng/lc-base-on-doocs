class Solution:
    def findBall(self, grid: List[List[int]]) -> List[int]:
        m, n = len(grid), len(grid[0])
        ans = []

        def dfs(x, y):
            nonlocal grid, m, n
            if x == m - 1:
                if grid[x][y] == 1:
                    if y < n - 1 and grid[x][y + 1] == 1:
                        return y + 1
                else:
                    if y > 0 and grid[x][y - 1] == -1:
                        return y - 1
                return -1
            if grid[x][y] == 1:
                if y < n - 1 and grid[x][y + 1] == 1:
                    return dfs(x + 1, y + 1)
            else:
                if y > 0 and grid[x][y - 1] == -1:
                    return dfs(x + 1, y - 1)
            return -1

        for i in range(n):
            ans.append(dfs(0, i))
        return ans
