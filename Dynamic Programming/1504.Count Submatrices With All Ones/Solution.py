class Solution:
    def numSubmat(self, mat: List[List[int]]) -> int:
        m, n = len(mat), len(mat[0])
        hs = [[0] * n for _ in range(m)]
        ans = 0
        for i in range(m):
            for j in range(n):
                if not mat[i][j]:
                    continue
                hs[i][j] = hs[i - 1][j] + 1 if i else 1
                h = hs[i][j]
                ans += h
                for y in range(j - 1, -1, -1):
                    h = min(h, hs[i][y])
                    ans += h
        return ans



