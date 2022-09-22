class Solution:
    def maximumRows(self, matrix: List[List[int]], numSelect: int) -> int:
        def cnt(x):
            ans = 0
            while x > 0:
                x &= x - 1
                ans += 1
            return ans

        def cover(mask):
            ans = 0
            for s in rows:
                if mask == (1 << n) - 1 or (mask | s) == mask:
                    ans += 1
            return ans

        m, n = len(matrix), len(matrix[0])
        rows = [0] * m
        for i in range(m):
            s = 0
            for j in range(n):
                if matrix[i][j] == 1:
                    s |= (1 << j)
            rows[i] = s
        s = 1 << n
        ans = 0
        for i in range(s):
            if cnt(i) != numSelect:
                continue
            ans = max(ans, cover(i))
        return ans
