class Solution:
    def modifiedMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        m, n = len(matrix), len(matrix[0])
        q = []
        cols = [-1] * n
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == -1:
                    q.append((i, j))
                elif matrix[i][j] > cols[j]:
                    cols[j] = matrix[i][j]
        for i, j in q:
            matrix[i][j] = cols[j]
        return matrix