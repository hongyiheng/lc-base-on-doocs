class Solution:
    def maxSideLength(self, mat: List[List[int]], threshold: int) -> int:
        m, n = len(mat), len(mat[0])
        pre = [[0] * (n + 1) for _ in range(m + 1)]
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                pre[i][j] = pre[i][j - 1] + pre[i - 1][j] - pre[i - 1][j - 1] + mat[i - 1][j - 1]

        def check(k):
            for i in range(1, m + 1):
                for j in range(1, n + 1):
                    if i < k or j < k:
                        continue
                    s = pre[i][j] - pre[i][j - k] - pre[i - k][j] + pre[i - k][j - k]
                    if s <= threshold:
                        return True
            return False

        left, right = 0, min(m, n)
        while left < right:
            mid = (left + right + 1) >> 1
            if check(mid):
                left = mid
            else:
                right = mid - 1
        return left