class Solution:
    def minFlips(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        ans1 = 0
        for i in range(m):
            l, r = 0, n - 1
            while l < r:
                if grid[i][l] != grid[i][r]:
                    ans1 += 1
                l += 1
                r -= 1

        ans2 = 0
        for i in range(n):
            l, r = 0, m - 1
            while l < r:
                if grid[l][i] != grid[r][i]:
                    ans2 += 1
                l += 1
                r -= 1
        return min(ans1, ans2)
