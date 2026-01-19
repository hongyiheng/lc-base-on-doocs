class Solution:
    def maxSideLength(self, mat: List[List[int]], threshold: int) -> int:
        def check(k):
            for i in range(m - k + 1):
                for j in range(n - k + 1):
                    s = f[i + k - 1][j + k - 1]
                    if j:
                        s -= f[i + k - 1][j - 1]
                    if i:
                        s -= f[i - 1][j + k - 1]
                    if i and j:
                        s += f[i - 1][j - 1]
                    if s <= threshold:
                        return True
            return False

        m, n = len(mat), len(mat[0])
        f = [[0] * n for _ in range(m)]
        for i in range(m):
            for j in range(n):
                v = mat[i][j]
                if i:
                    v += f[i - 1][j]
                if j:
                    v += f[i][j - 1]
                if i and j:
                    v -= f[i - 1][j - 1]
                f[i][j] = v

        l, r = 0, min(m, n)
        while l < r:
            mid = (l + r + 1) >> 1
            if check(mid):
                l = mid
            else:
                r = mid - 1
        return r