class Solution:
    def knightProbability(self, n: int, k: int, row: int, column: int) -> float:
        mem = [[[-1] * (k + 1) for _ in range(n)] for _ in range(n)]
        for i in range(n):
            for j in range(n):
                mem[i][j][0] = 1
        dirs = [[1, 2], [2, 1], [-2, 1], [1, -2], [-1, 2], [2, -1], [-1, -2], [-2, -1]]

        def dfs(x, y, k):
            if x < 0 or x >= n or y < 0 or y >=n:
                return 0
            if mem[x][y][k] != -1:
                return mem[x][y][k]
            ans = 0
            for d in dirs:
                ans += dfs(x + d[0], y + d[1], k - 1)
            mem[x][y][k] = ans / 8
            return mem[x][y][k]

        return dfs(row, column, k)