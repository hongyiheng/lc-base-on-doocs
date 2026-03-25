class Solution:
    def canPartitionGrid(self, grid: List[List[int]]) -> bool:
        m, n = len(grid), len(grid[0])
        pre = [[0] * n for _ in range(m)]
        s = 0
        for i in range(m):
            for j in range(n):
                pre[i][j] = grid[i][j]
                if i:
                    pre[i][j] += pre[i - 1][j]
                if j:
                    pre[i][j] += pre[i][j - 1]
                if i and j:
                    pre[i][j] -= pre[i - 1][j - 1]
                s += grid[i][j]
        for i in range(m):
            if pre[i][-1] * 2 == s:
                return True
        for j in range(n):
            if pre[-1][j] * 2 == s:
                return True
        return False
