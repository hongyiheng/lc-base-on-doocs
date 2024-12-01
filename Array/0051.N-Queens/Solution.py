class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        def check(g, x, y):
            for d in [[-1, 0], [-1, -1], [-1, 1]]:
                nx, ny = x + d[0], y + d[1]
                while 0 <= nx < n and 0 <= ny < n:
                    if g[nx][ny]:
                        return False
                    nx += d[0]
                    ny += d[1]
            return True

        def dfs(g, x):
            if x == n:
                ans.append(["".join(["Q" if v else "." for v in r]) for r in g])
                return
            for y in range(n):
                if not check(g, x, y):
                    continue
                g[x][y] = True
                dfs(g, x + 1)
                g[x][y] = False

        g = [[False] * n for _ in range(n)]
        ans = []
        dfs(g, 0)
        return ans