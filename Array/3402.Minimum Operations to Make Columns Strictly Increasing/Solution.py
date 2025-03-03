class Solution:
    def minimumOperations(self, grid: List[List[int]]) -> int:
        ans = 0
        for j in range(len(grid[0])):
            for i in range(1, len(grid)):
                pre, v = grid[i - 1][j], grid[i][j]
                if v <= pre:
                    ans += pre - v + 1
                    grid[i][j] = pre + 1
        return ans
