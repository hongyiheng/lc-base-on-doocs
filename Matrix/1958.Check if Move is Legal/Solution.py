class Solution:
    def checkMove(self, board: List[List[str]], rMove: int, cMove: int, color: str) -> bool:
        m, n = len(board), len(board[0])
        dirs = [[-1, 0], [0, 1], [1, 0], [0, -1], [-1, -1], [-1, 1], [1, 1], [1, -1]]
        for d in dirs:
            nx, ny = rMove + d[0], cMove + d[1]
            mid = False
            while 0 <= nx < m and 0 <= ny < n:
                if board[nx][ny] == '.':
                    break
                if board[nx][ny] == color:
                    if mid:
                        return True
                    break
                else:
                    mid = True
                nx, ny = nx + d[0], ny + d[1]
        return False