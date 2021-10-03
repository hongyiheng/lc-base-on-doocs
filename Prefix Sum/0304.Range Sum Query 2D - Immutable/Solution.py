class NumMatrix:
    def __init__(self, matrix: List[List[int]]):
        m = len(matrix)
        n = len(matrix[0])
        self.dp = [[0 for _ in range(n)] for _ in range(m)]
        _dp = self.dp
        print(_dp)
        for i in range(m):
            for j in range(n):
                if i == 0 and j == 0:
                    _dp[i][j] = matrix[i][j]
                elif i == 0:
                    _dp[i][j] = _dp[i][j - 1] + matrix[i][j]
                elif j == 0:
                    _dp[i][j] = _dp[i - 1][j] + matrix[i][j]
                else:
                    _dp[i][j] = _dp[i][j - 1] + _dp[i - 1][j] - _dp[i - 1][j - 1] + matrix[i][j]

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        _dp = self.dp
        print()
        if row1 == 0 and col1 == 0:
            return _dp[row2][col2]
        elif row1 == 0:
            return _dp[row2][col2] - _dp[row2][col1 - 1]
        elif col1 == 0:
            return _dp[row2][col2] - _dp[row1 - 1][col2]
        return _dp[row2][col2] - _dp[row1 - 1][col2] - _dp[row2][col1 - 1] + _dp[row1 - 1][col1 - 1]



# Your NumMatrix object will be instantiated and called as such:
# obj = NumMatrix(matrix)
# param_1 = obj.sumRegion(row1,col1,row2,col2)