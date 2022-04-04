class Solution:
    def matrixReshape(self, mat: List[List[int]], r: int, c: int) -> List[List[int]]:
        m, n = len(mat), len(mat[0])
        if m * n != r * c:
            return mat
        ans = [[0] * c for _ in range(r)]
        idx = 0
        for i in range(r):
            for j in range(c):
                x, y = idx // n, idx % n
                ans[i][j] = mat[x][y]
                idx += 1
        return ans