class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        ans = []
        g = [[False] * n for _ in range(n)]

        def dfs(g, x):
            nonlocal n, ans
            if x == n:
                item = []
                for row in g:
                    s = ""
                    for b in row:
                        s += "Q" if b else "."
                    item.append(s)
                ans.append(item)
                return
            for j in range(n):
                if is_valid(g, x, j):
                    g[x][j] = True
                    dfs(g, x + 1)
                    g[x][j] = False

        def is_valid(g, x, y):
            for d in [[-1, 1], [-1, -1], [-1, 0]]:
                nx, ny = x + d[0], y + d[1]
                while 0 <= nx < n and 0 <= ny < n:
                    if g[nx][ny]:
                        return False
                    nx += d[0]
                    ny += d[1]
            return True

        dfs(g, 0)
        return ans
