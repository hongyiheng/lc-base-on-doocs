class Solution:
    def diagonalSum(self, mat: List[List[int]]) -> int:
        n = len(mat)
        ans = 0
        for i in range(n):
            ans += mat[i][i] + mat[i][n - i - 1]
            if n - i - 1 == i:
                ans -= mat[i][i]
        return ans