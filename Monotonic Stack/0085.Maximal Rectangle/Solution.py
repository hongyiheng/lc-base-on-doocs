class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        def max_area(hs):
            hs.append(-1)
            ans = 0
            q = []
            for i, v in enumerate(hs):
                while q and hs[q[-1]] > v:
                    h = hs[q.pop()]
                    l = q[-1] if q else -1
                    ans = max(ans, (i - 1 - l) * h)
                q.append(i)
            return ans

        n, m = len(matrix), len(matrix[0])
        g = [[0] * m for _ in range(n)]
        for i in range(n):
            for j in range(m):
                if matrix[i][j] == '1':
                    last = g[i - 1][j] if i > 0 else 0
                    g[i][j] = last + 1
        ans = 0
        for i in range(n):
            ans = max(ans, max_area(g[i]))
        return ans
