class Solution:
    def minFlips(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        ans = 0
        for i in range(m // 2):
            for j in range(n // 2):
                v = grid[i][j] + grid[m - 1 - i][j] + grid[i][n - 1 - j] + grid[m - 1 - i][n - 1 - j]
                ans += min(v, 4 - v)

        if m % 2 and n % 2:
            ans += grid[m // 2][n // 2]

        diff = cnt = 0
        if m % 2:
            for j in range(n // 2):
                if grid[m // 2][j] != grid[m // 2][n - 1 - j]:
                    diff += 1
                else:
                    cnt += grid[m // 2][j] * 2
        if n % 2:
            for i in range(m // 2):
                if grid[i][n // 2] != grid[m - 1 - i][n // 2]:
                    diff += 1
                else:
                    cnt += grid[i][n // 2] * 2

        return ans + (diff if diff else cnt % 4)

