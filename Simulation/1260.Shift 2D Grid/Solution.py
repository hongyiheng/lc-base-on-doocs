class Solution:
    def shiftGrid(self, grid: List[List[int]], k: int) -> List[List[int]]:
        m, n = len(grid), len(grid[0])
        k %= (m * n)
        cur = 0 if k == 0 else m * n - k
        ans = []
        while len(ans) < m:
            row = []
            for _ in range(n):
                x, y = cur // n, cur % n
                row.append(grid[x][y])
                if cur + 1 == m * n:
                    cur = 0
                else:
                    cur += 1
            ans.append(row)
        return ans