class Solution:
    def largestMagicSquare(self, grid: List[List[int]]) -> int:
        def f(x, y, k):
            rows = [0] * k
            cols = [0] * k
            diagonal = [0] * 2
            for i in range(x, x + k):
                for j in range(y, y + k):
                    v = grid[i][j]
                    if i - x == j - y:
                        diagonal[0] += v
                    if i - x + j - y + 1 == k:
                        diagonal[1] += v
                    rows[i - x] += v
                    cols[j - y] += v
            t = rows[0]
            for i in range(k):
                if rows[i] != t or cols[i] != t:
                    return False
            return diagonal[0] == diagonal[1] == t



        m, n = len(grid), len(grid[0])
        for k in range(min(m, n), 1, -1):
            for i in range(m - k + 1):
                for j in range(n - k + 1):
                    if f(i, j, k):
                        return k
        return 1