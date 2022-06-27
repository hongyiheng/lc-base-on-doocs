class Solution:
    def checkValid(self, matrix: List[List[int]]) -> bool:
        n = len(matrix)
        row, col = [0] * (n + 1), [0] * (n + 1)
        for i in range(n):
            for j in range(n):
                a, b = matrix[i][j], matrix[j][i]
                row[a] += 1
                col[b] += 1
                if row[a] != 1 or col[b] != 1:
                    return False
            row, col = [0] * (n + 1), [0] * (n + 1)
        return True

