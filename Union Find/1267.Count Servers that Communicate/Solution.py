class Solution:
    def countServers(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        p = [i for i in range(m * n)]
        area = [1] * (m * n)

        def find(x):
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]

        def union(i1, i2):
            r1, r2 = find(i1), find(i2)
            if r1 != r2:
                area[r2] += area[r1]
                p[r1] = r2

        for i in range(m):
            for j in range(n):
                if grid[i][j] != 1:
                    continue
                index = i * n + j
                row = i + 1
                while row < m:
                    if grid[row][j] == 1:
                        union(index, row * n + j)
                    row += 1
                col = j + 1
                while col < n:
                    if grid[i][col] == 1:
                        union(index, i * n + col)
                    col += 1
        ans = 0
        for i in range(m):
            for j in range(n):
                index = i * n + j
                if grid[i][j] == 1 and p[index] == index and area[index] > 1:
                    ans += area[index]
        return ans
