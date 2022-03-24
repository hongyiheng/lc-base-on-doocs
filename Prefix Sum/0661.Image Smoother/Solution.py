class Solution:
    def imageSmoother(self, img: List[List[int]]) -> List[List[int]]:
        m, n = len(img), len(img[0])
        pre = [[0] * (n + 2) for _ in range(m + 2)]
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                pre[i][j] = pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1] + img[i - 1][j - 1]
        ans = [[0] * n for _ in range(m)]
        for i in range(m):
            for j in range(n):
                top = max(0, i - 1)
                bottom = min(m - 1, i + 1)
                left = max(0, j - 1)
                right = min(n - 1, j + 1)
                cnt = (bottom - top + 1) * (right - left + 1)
                val = pre[bottom + 1][right + 1] - pre[top][right + 1] - pre[bottom + 1][left] + pre[top][left]
                ans[i][j] = val // cnt
        return ans