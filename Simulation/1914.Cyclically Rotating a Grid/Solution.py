class Solution:
    def rotateGrid(self, grid: List[List[int]], k: int) -> List[List[int]]:
        def rotate(x1, y1, x2, y2):
            nonlocal k
            q = []
            for j in range(y1, y2 + 1):
                q.append(grid[x1][j])
            for i in range(x1 + 1, x2):
                q.append(grid[i][y2])
            for j in range(y2, y1 - 1, -1):
                q.append(grid[x2][j])
            for i in range(x2 - 1, x1, -1):
                q.append(grid[i][y1])
            n = len(q)
            idx = k % n
            for j in range(y1, y2 + 1):
                grid[x1][j] = q[idx % n]
                idx += 1
            for i in range(x1 + 1, x2):
                grid[i][y2] = q[idx % n]
                idx += 1
            for j in range(y2, y1 - 1, -1):
                grid[x2][j] = q[idx % n]
                idx += 1
            for i in range(x2 - 1, x1, -1):
                grid[i][y1] = q[idx % n]
                idx += 1

        m, n = len(grid), len(grid[0])
        x1, y1, x2, y2 = 0, 0, m - 1, n - 1
        while x1 < x2 and y1 < y2:
            rotate(x1, y1, x2, y2)
            x1 += 1
            y1 += 1
            x2 -= 1
            y2 -= 1
        return grid