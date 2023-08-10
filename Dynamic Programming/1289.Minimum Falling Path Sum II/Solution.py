class Solution:
    def minFallingPathSum(self, grid: List[List[int]]) -> int:
        @cache
        def dfs(i, j):
            nonlocal n
            if i == n:
                return 0
            arr = sorted([(v, k) for k, v in enumerate(grid[i]) if k != j])
            return min(dfs(i + 1, arr[0][1]) + arr[0][0], dfs(i + 1, arr[1][1]) + arr[1][0])

        n = len(grid)
        if n == 1:
            return grid[0][0]
        return dfs(0, -1)