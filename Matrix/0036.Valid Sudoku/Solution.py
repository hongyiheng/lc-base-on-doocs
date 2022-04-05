class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row = [[0] * 10 for _ in range(9)]
        col = [[0] * 10 for _ in range(9)]
        box = [[[0] * 10 for _ in range(3)] for _ in range(3)]
        for x in range(9):
            for y in range(9):
                if board[x][y] == '.':
                    continue
                v = int(board[x][y])
                if row[x][v] != 0:
                    return False
                else:
                    row[x][v] += 1
                if col[y][v] != 0:
                    return False
                else:
                    col[y][v] += 1
                if box[x // 3][y // 3][v] != 0:
                    return False
                else:
                    box[x // 3][y // 3][v] += 1
        return True