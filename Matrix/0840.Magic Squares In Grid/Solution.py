class Solution:
    def numMagicSquaresInside(self, grid: List[List[int]]) -> int:
        def check(x, y):
            nonlocal m, n
            if x == 0 or x == m - 1 or y == 0 or y == n - 1:
                return False
            msk = 0
            t = grid[x - 1][y - 1] + grid[x][y] + grid[x + 1][y + 1]
            for i in range(-1, 2):
                for j in range(-1, 2):
                    msk |= 1 << grid[x + i][y + j]
                if grid[x - 1][y + i] + grid[x][y + i] + grid[x + 1][y + i] != t:
                    return False
                if grid[x + i][y - 1] + grid[x + i][y] + grid[x + i][y + 1] != t:
                    return False
            return msk == (1 << 10) - 2 and grid[x - 1][y + 1] + grid[x][y] + grid[x + 1][y - 1] == t

        m, n = len(grid), len(grid[0])
        ans = 0
        for i in range(1, m - 1):
            for j in range(1, n - 1):
                ans += (1 if check(i, j) else 0)
        return ans