class Solution:
    def rangeAddQueries(self, n: int, queries: List[List[int]]) -> List[List[int]]:
        ans = [[0] * n for _ in range(n)]
        for i1, j1, i2, j2 in queries:
            for i in range(i1, i2 + 1):
                ans[i][j1] += 1
                if j2 + 1 < n:
                    ans[i][j2 + 1] -= 1
        for i in range(n):
            v = 0
            for j in range(n):
                v += ans[i][j]
                ans[i][j] = v
        return ans
