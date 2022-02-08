class Solution:
    def gridIllumination(self, n: int, lamps: List[List[int]], queries: List[List[int]]) -> List[int]:
        dirs = [[0, 0], [1, 0], [0, 1], [1, 1], [-1, -1], [1, -1], [-1, 1], [-1, 0], [0, -1]]
        row, col, left, right = dict(), dict(), dict(), dict()
        light = set()
        for lamp in lamps:
            x, y = lamp
            l, r = y - x, x + y
            if (x * n + y) in light:
                continue
            light.add(x * n + y)
            row[x] = row.get(x, 0) + 1
            col[y] = col.get(y, 0) + 1
            left[l] = left.get(l, 0) + 1
            right[r] = right.get(r, 0) + 1
        k = len(queries)
        ans = [0] * k
        for i in range(k):
            x, y = queries[i]
            if x in row or y in col or (y - x) in left or (x + y) in right:
                ans[i] = 1
            for dir in dirs:
                nx, ny = x + dir[0], y + dir[1]
                if (nx * n + ny) in light:
                    light.remove(nx * n + ny)
                    nl, nr = ny - nx, nx + ny
                    if row.get(nx, 0) > 1:
                        row[nx] -= 1
                    else:
                        row.pop(nx, "")
                    if col.get(ny, 0) > 1:
                        col[ny] -= 1
                    else:
                        col.pop(ny, "")
                    if left.get(nl, 0) > 1:
                        left[nl] -= 1
                    else:
                        left.pop(nl, "")
                    if right.get(nr, 0) > 1:
                        right[nr] -= 1
                    else:
                        right.pop(nr, "")
        return ans