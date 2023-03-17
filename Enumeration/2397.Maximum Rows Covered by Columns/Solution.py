class Solution:
    def maximumRows(self, matrix: List[List[int]], numSelect: int) -> int:
        def bit_cnt(x):
            ans = 0
            while x:
                x -= x & - x
                ans += 1
            return ans

        m, n = len(matrix), len(matrix[0])
        row = [0] * m
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 1:
                    row[i] |= (1 << j)
        ans = 0
        for i in range((1 << n) + 1):
            if bit_cnt(i) != numSelect:
                continue
            cnt = 0
            for r in row:
                if r | i == i:
                    cnt += 1
            ans = max(cnt, ans)
        return ans
