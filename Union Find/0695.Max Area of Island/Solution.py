class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        p = [i for i in range(m * n)]
        area = [1] * (m * n)

        def find(x):
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]

        def union(i1, i2):
            r1 = find(i1)
            r2 = find(i2)
            if r1 != r2:
                area[r2] += area[r1]
                p[r1] = r2

        for i in range(m):
            for j in range(n):
                if grid[i][j] != 1:
                    continue
                index = i * n + j
                if i > 0 and grid[i - 1][j] == 1:
                    union(index, index - n)
                if j > 0 and grid[i][j - 1] == 1:
                    union(index, index - 1)
        ans = 0
        for i in range(m):
            for j in range(n):
                index = i * n + j
                if grid[i][j] == 1 and p[index] == index:
                    ans = max(ans, area[index])
        return ans