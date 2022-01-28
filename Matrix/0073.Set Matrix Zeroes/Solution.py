class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        m, n = len(matrix), len(matrix[0])
        x, y = [], []
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    x.append(i)
                    y.append(j)

        for i in x:
            for j in range(n):
                matrix[i][j] = 0
        for j in y:
            for i in range(m):
                matrix[i][j] = 0