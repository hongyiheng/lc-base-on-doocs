class Solution:
    def oddCells(self, m: int, n: int, indices: List[List[int]]) -> int:
        g = [[0] * n for _ in range(m)]
        for x, y in indices:
            for j in range(n):
                g[x][j] += 1
            for i in range(m):
                g[i][y] += 1
        ans = 0
        for i in range(m):
            for j in range(n):
                if g[i][j] % 2:
                    ans += 1
        return ans