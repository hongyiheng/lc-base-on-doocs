class Solution:
    def findColumnWidth(self, grid: List[List[int]]) -> List[int]:
        m, n = len(grid), len(grid[0])
        ans = [0] * n
        for j in range(n):
            for i in range(m):
                ans[j] = max(ans[j], len(str(grid[i][j])))
        return ans