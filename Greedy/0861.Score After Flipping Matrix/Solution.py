class Solution:
    def matrixScore(self, grid: List[List[int]]) -> int:
        def reverse_row(i):
            for j in range(n):
                grid[i][j] ^= 1

        def reverse_col(j):
            for i in range(m):
                grid[i][j] ^= 1

        m, n = len(grid), len(grid[0])
        for i in range(m):
            if not grid[i][0]:
                reverse_row(i)
        for j in range(n):
            cnt = 0
            for i in range(m):
                cnt += grid[i][j]
            if cnt < m / 2:
                reverse_col(j)
        ans = 0
        for i in range(m):
            for j in range(n):
                if not grid[i][j]:
                    continue
                ans += 1 << (n - j - 1)
        return ans