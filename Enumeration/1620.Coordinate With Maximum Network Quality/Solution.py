class Solution:
    def bestCoordinate(self, towers: List[List[int]], radius: int) -> List[int]:
        M = 55
        g = [[0] * M for _ in range(M)]
        ans = [0, 0]
        cur = 0
        for i in range(M):
            for j in range(M):
                for x, y, w in towers:
                    d = math.sqrt((x - i) * (x - i) + (y - j) * (y - j))
                    if d <= radius:
                        g[i][j] += w // (1 + d)
                if g[i][j] > cur:
                    cur = g[i][j]
                    ans = [i, j ]
        return ans
