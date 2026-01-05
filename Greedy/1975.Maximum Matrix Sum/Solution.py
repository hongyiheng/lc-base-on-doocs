class Solution:
    def maxMatrixSum(self, matrix: List[List[int]]) -> int:
        m, n = len(matrix), len(matrix[0])
        exist_zero = False
        neg, mi = 0, abs(matrix[0][0])
        for i, row in enumerate(matrix):
            for v in row:
                if v < 0:
                    neg -= 1
                elif v == 0:
                    exist_zero = True
                mi = min(mi, abs(v))
        ans = sum([v if v >= 0 else -v for i, row in enumerate(matrix) for v in row])
        if exist_zero or neg % 2 == 0:
            return ans
        return ans - 2 * mi
