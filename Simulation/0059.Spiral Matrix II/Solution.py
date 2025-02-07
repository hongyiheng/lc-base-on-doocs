class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        ans = [[0] * n for _ in range(n)]
        ds = [[0, 1], [1, 0], [-1, 0], [0, -1]]
        x, y, v = 0, -1, 1
        while v <= n * n:
            for d in ds:
                nx, ny = x + d[0], y + d[1]
                f = False
                while 0 <= nx < n and 0 <= ny < n and ans[nx][ny] == 0:
                    f = True
                    ans[nx][ny] = v
                    v += 1
                    nx += d[0]
                    ny += d[1]
                if f:
                    x, y = nx - d[0], ny - d[1]
                    break
        return ans



