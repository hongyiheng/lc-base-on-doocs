class Solution:
    def countNegatives(self, grid: List[List[int]]) -> int:
        ans, n = 0, len(grid[0])
        for row in grid:
            left, right = 0, n - 1
            while left < right:
                mid = (left + right) >> 1
                if row[mid] >= 0:
                    left = mid + 1
                else:
                    right = mid
            if row[left] < 0:
                ans += n - left
        return ans