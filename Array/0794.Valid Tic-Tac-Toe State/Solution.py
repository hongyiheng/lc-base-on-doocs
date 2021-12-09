class Solution:
    def validTicTacToe(self, board: List[str]) -> bool:
        x_count, o_count = 0, 0
        matrix = [[0 for _ in range(3)] for _ in range(3)]
        for i, v in enumerate(board):
            for j in range(len(v)):
                if v[j] == 'X':
                    x_count += 1
                    matrix[i][j] = 1
                elif v[j] == 'O':
                    o_count += 1
                    matrix[i][j] = 2
        if o_count > x_count:
            return False
        win = set()
        for i in range(3):
            if matrix[i][0] == matrix[i][1] and matrix[i][0] == matrix[i][2]:
                if matrix[i][0] != 0:
                    win.add(matrix[i][0])
            if matrix[0][i] == matrix[1][i] and matrix[0][i] == matrix[2][i]:
                if matrix[0][i] != 0:
                    win.add(matrix[0][i])
        if matrix[0][0] == matrix[1][1] and matrix[0][0] == matrix[2][2]:
            if matrix[0][0] != 0:
                win.add(matrix[0][0])
        if matrix[0][2] == matrix[1][1] and matrix[0][2] == matrix[2][0]:
            if matrix[0][2] != 0:
                win.add(matrix[0][2])
        if 1 in win and 2 in win:
            return False
        elif 1 in win:
            return x_count - o_count == 1
        elif 2 in win:
            return x_count == o_count
        return x_count - o_count <= 1