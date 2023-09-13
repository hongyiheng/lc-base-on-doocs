class Solution:
    def checkValidGrid(self, grid: List[List[int]]) -> bool:
        n = len(grid)
        if grid[0][0]:
            return False
        cnt = x = y = 0
        while cnt < n * n - 1:
            flag = False
            cnt += 1
            for d in [[-2, 1], [-2, -1], [2, 1], [2, -1], [1, 2], [-1, 2], [1, -2], [-1, -2]]:
                nx, ny = x + d[0], y + d[1]
                if nx < 0 or nx >= n or ny < 0 or ny >= n:
                    continue
                if cnt == grid[nx][ny]:
                    x, y = nx, ny
                    flag = True
            if not flag:
                return False
        return True