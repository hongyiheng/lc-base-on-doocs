class Solution:
    def numRookCaptures(self, board: List[List[str]]) -> int:
        m, n = len(board), len(board[0])
        x = y = 0
        for i in range(m):
            for j in range(n):
                if board[i][j] == 'R':
                    x, y = i, j
                    break
        ans = 0
        for d in [[1, 0], [0, 1], [-1, 0], [0, -1]]:
            nx, ny = x + d[0], y + d[1]
            while 0 <= nx < m and 0 <= ny < n:
                if board[nx][ny] != '.':
                    if board[nx][ny] == 'p':
                        ans += 1
                    break
                nx += d[0]
                ny += d[1]
        return ans