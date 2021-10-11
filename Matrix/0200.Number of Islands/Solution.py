class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])
        self.ans = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    self.infect(grid, i, j)
                    self.ans += 1
        return self.ans

    def infect(self, grid: List[List[str]], i, j):
        if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]) or grid[i][j] != '1':
            return
        grid[i][j] = 'L'
        for x, y in [[0, 1], [0, -1], [1, 0], [-1, 0]]:
            self.infect(grid, i + x, j + y)