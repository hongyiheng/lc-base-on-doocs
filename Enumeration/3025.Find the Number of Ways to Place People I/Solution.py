class Solution:
    def numberOfPairs(self, points: List[List[int]]) -> int:
        def cmp(a, b):
            if a[0] != b[0]:
                return a[0] - b[0]
            return b[1] - a[1]

        def check(a, b):
            x, y = a
            nx, ny = b
            if x > nx or y < ny:
                return False
            for i in range(x, nx + 1):
                for j in range(ny, y + 1):
                    if (i == x and j == y) or (i == nx and j == ny):
                        continue
                    if g[i][j]:
                        return False
            return True

        points.sort(key=cmp_to_key(cmp))
        g = [[False] * 51 for _ in range(51)]
        for x, y in points:
            g[x][y] = True
        n = len(points)
        ans = 0
        for i in range(n):
            for j in range(i + 1, n):
                if check(points[i], points[j]):
                    ans += 1
        return ans
