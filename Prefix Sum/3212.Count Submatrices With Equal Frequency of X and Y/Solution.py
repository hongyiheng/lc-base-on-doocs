class Solution:
    def numberOfSubmatrices(self, grid: List[List[str]]) -> int:
        m, n = len(grid), len(grid[0])
        f = [[[0] * 2 for _ in range(n)] for _ in range(m)]
        ans = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 'X':
                    f[i][j][0] += 1
                elif grid[i][j] == 'Y':
                    f[i][j][1] += 1
                if i:
                    f[i][j][0] += f[i - 1][j][0]
                    f[i][j][1] += f[i - 1][j][1]
                if j:
                    f[i][j][0] += f[i][j - 1][0]
                    f[i][j][1] += f[i][j - 1][1]
                if i and j:
                    f[i][j][0] -= f[i - 1][j - 1][0]
                    f[i][j][1] -= f[i - 1][j - 1][1]
                if f[i][j][0] and f[i][j][0] == f[i][j][1]:
                    ans += 1
        return ans