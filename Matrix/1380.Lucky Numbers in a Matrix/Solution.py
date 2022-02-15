class Solution:
    def luckyNumbers (self, matrix: List[List[int]]) -> List[int]:
        m, n = len(matrix), len(matrix[0])
        row, col = [float('inf')] * m, [float('-inf')] * n
        for i in range(m):
            for j in range(n):
                row[i] = min(row[i], matrix[i][j])
                col[j] = max(col[j], matrix[i][j])
        return [v for v in set(row) & set(col)]