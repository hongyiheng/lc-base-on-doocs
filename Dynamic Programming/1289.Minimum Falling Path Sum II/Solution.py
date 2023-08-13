class Solution:
    def minFallingPathSum(self, grid: List[List[int]]) -> int:
        @cache
        def dfs(i, j):
            nonlocal n
            if i == n:
                return 0
            a = b = a_id = b_id = inf
            for k, v in enumerate(grid[i]):
                if k == j:
                    continue
                if v < a:
                    a, b = v, a
                    a_id, b_id = k, a_id
                elif v < b:
                    b_id, b = k, v
            return min(dfs(i + 1, a_id) + a, dfs(i + 1, b_id) + b)

        n = len(grid)
        if n == 1:
            return grid[0][0]
        return dfs(0, -1)