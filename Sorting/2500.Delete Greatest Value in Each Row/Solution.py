class Solution:
    def deleteGreatestValue(self, grid: List[List[int]]) -> int:
        for row in grid:
            row.sort()
        ans = 0
        for j in range(len(grid[0])):
            mx = grid[0][j]
            for i in range(1, len(grid)):
                mx = max(mx, grid[i][j])
            ans += mx
        return ans