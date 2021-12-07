class Solution:
    def colorBorder(self, grid: List[List[int]], row: int, col: int, color: int) -> List[List[int]]:
        m, n, cur = len(grid), len(grid[0]), grid[row][col]
        visit = [[False for _ in range(n)] for _ in range(m)]

        def dfs(x, y, ox, oy):
            if x >= 0 and x < m and y >= 0 and y < n:
                if not visit[x][y]:
                    if grid[x][y] == cur:
                        visit[x][y] = True
                        dfs(x + 1, y, x, y)
                        dfs(x - 1, y, x, y)
                        dfs(x, y + 1, x, y)
                        dfs(x, y - 1, x, y)
                    else:
                        grid[ox][oy] = color
            else:
                grid[ox][oy] = color

        dfs(row, col, row, col)
        return grid
