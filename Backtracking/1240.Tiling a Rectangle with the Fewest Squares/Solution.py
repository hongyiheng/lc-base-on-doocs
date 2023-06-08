class Solution:
    def tilingRectangle(self, n: int, m: int) -> int:
        def dfs(x, y, cur):
            nonlocal ans
            if cur >= ans:
                return
            if x + 1 == m and y + 1 == n:
                ans = min(ans, cur + (0 if g[x][y] else 1))
            nx, ny = x, y + 1
            if ny == n:
                nx += 1
                ny = 0
            if g[x][y]:
                dfs(nx, ny, cur)
            else:
                for k in range(min(m - x, n - y), 0, - 1):
                    blank = True
                    for i in range(x, x + k):
                        if not blank:
                            break
                        for j in range(y, y + k):
                            if g[i][j]:
                                blank = False
                                break
                    if not blank:
                        continue
                    for i in range(x, x + k):
                        for j in range(y, y + k):
                            g[i][j] = True
                    dfs(nx, ny, cur + 1)
                    for i in range(x, x + k):
                        for j in range(y, y + k):
                            g[i][j] = False


        g = [[False] * n for _ in range(m)]
        ans = n * m
        dfs(0, 0, 0)
        return ans