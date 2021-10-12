class Solution:
    def closedIsland(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        p = [i for i in range(m * n)]
        border = [False] * (m * n)

        def find(x):
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    continue
                index = i * n + j
                if i > 0 and grid[i - 1][j] == 0:
                    p[find(index)] = find(index - n)
                if j > 0 and grid[i][j - 1] == 0:
                    p[find(index)] = find(index - 1)
        for i in range(m):
            for j in range(n):
                if i == 0 or i == m - 1 or j == 0 or j == n - 1:
                    border[find(i * n + j)] = True
        ans = 0
        for i in range(m):
            for j in range(n):
                index = i * n + j
                if grid[i][j] == 0 and p[index] == index and not border[index]:
                    ans += 1
        return ans


