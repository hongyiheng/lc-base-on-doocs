class Solution:
    def kthLargestValue(self, matrix: List[List[int]], k: int) -> int:
        m, n = len(matrix), len(matrix[0])
        f = [[0] * n for _ in range(m)]
        q = []
        for i in range(m):
            for j in range(n):
                v = matrix[i][j]
                if i > 0:
                    v ^= f[i - 1][j]
                if j > 0:
                    v ^= f[i][j - 1]
                if i > 0 and j > 0:
                    v ^= f[i - 1][j - 1]
                f[i][j] = v
                q.append(v)
        q.sort(reverse=True)
        return q[k - 1]
