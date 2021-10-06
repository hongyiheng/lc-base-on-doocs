class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        temp = [[0] * (n + 2) for _ in range(m + 2)]

        for i in range(m + 2):
            for j in range(n + 2):
                if i == 0 or i == m + 1 or j == 0 or j == n + 1:
                    temp[i][j] = 0
                else:
                    temp[i][j] = board[i - 1][j - 1]

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                live_count = temp[i - 1][j - 1] + temp[i - 1][j] + temp[i - 1][j + 1] + temp[i][j - 1] +  temp[i][j + 1] + temp[i + 1][j - 1] + temp[i + 1][j] + temp[i + 1][j + 1]
                if live_count > 3 or live_count < 2:
                    board[i - 1][j - 1] = 0
                if live_count == 3:
                    board[i - 1][j - 1] = 1