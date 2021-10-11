class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])
        p = [i for i in range(m * n)]

        def find(x):
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]

        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    if i < m - 1 and grid[i + 1][j] == '1':
                        p[find(i * n + j)] = find((i + 1) * n + j)
                    if j < n - 1 and grid[i][j + 1] == '1':
                        p[find(i * n + j)] = find((i * n + j + 1))
        ans = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1' and i * n + j == find(i * n + j):
                    ans += 1
        return ans
