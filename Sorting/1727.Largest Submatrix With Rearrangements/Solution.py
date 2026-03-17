class Solution:
    def largestSubmatrix(self, matrix: List[List[int]]) -> int:
        m, n = len(matrix), len(matrix[0])
        hs = [0] * n
        ans = 0
        for i in range(m):
            for j in range(n):
                if matrix[i][j]:
                    hs[j] += 1
                else:
                    hs[j] = 0
            for k, h in enumerate(sorted(hs)):
                ans = max(ans, h * (n - k))
        return ans