class Solution:
    def numSpecial(self, mat: List[List[int]]) -> int:
        m, n = len(mat), len(mat[0])
        row, col = [0] * m, [0] * n
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 1:
                    row[i] += 1
                    col[j] += 1
        ans = 0
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 1 and row[i] == 1 and col[j] == 1:
                    ans += 1
        return ans