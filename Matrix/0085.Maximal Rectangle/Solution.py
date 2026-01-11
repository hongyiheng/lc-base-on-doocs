class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        def f(hr):
            q = []
            ans = 0
            hr = hr + [0]
            for i, v in enumerate(hr):
                while q and hr[q[-1]] > v:
                    h = hr[q.pop()]
                    left = q[-1] if q else -1
                    ans = max(ans, h * (i - left - 1))
                q.append(i)
            return ans

        m, n = len(matrix), len(matrix[0])
        hg = [[0] * n for _ in range(m)]
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == '1':
                    hg[i][j] = (hg[i - 1][j] if i > 0 else 0) + 1
        ans = 0
        for hr in hg:
            ans = max(ans, f(hr))
        return ans



