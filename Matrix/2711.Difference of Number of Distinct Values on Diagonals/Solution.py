class Solution:
    def differenceOfDistinctValues(self, grid: List[List[int]]) -> List[List[int]]:
        def dfs(x, y, pre):
            nonlocal m, n
            if x == m - 1 or y == n - 1:
                ans[x][y] = len(pre)
                return {grid[x][y]}
            tmp = len(pre)
            pre.add(grid[x][y])
            suf = dfs(x + 1, y + 1, pre)
            ans[x][y] = abs(tmp - len(suf))
            suf.add(grid[x][y])
            return suf

        m, n = len(grid), len(grid[0])
        ans = [[0] * n for _ in range(m)]
        for i in range(m):
            dfs(i, 0, set())
        for j in range(n):
            dfs(0, j, set())
        return ans