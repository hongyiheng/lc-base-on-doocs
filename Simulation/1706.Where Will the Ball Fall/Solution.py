class Solution:
    def findBall(self, grid: List[List[int]]) -> List[int]:
        def dfs(x, y):
            nonlocal grid, m, n
            if x >= m:
                return y
            if y < n - 1 and grid[x][y] == grid[x][y + 1] == 1:
                return dfs(x + 1, y + 1)
            elif y > 0 and grid[x][y] == grid[x][y - 1] == -1:
                return dfs(x + 1, y - 1)
            return -1

        m, n = len(grid), len(grid[0])
        ans = []
        for i in range(n):
            ans.append(dfs(0, i))
        return ans
