class Solution:
    def solve(self, board: List[List[str]]) -> None:
        m, n = len(board), len(board[0])
        p = [i for i in range(m * n)]
        border = [False] * (m * n)

        def find(x):
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]

        def union(i1, i2):
            r1, r2 = find(i1), find(i2)
            if r1 != r2:
                p[r1] = r2

        for i in range(m):
            for j in range(n):
                if board[i][j] != 'O':
                    continue
                index = i * n + j
                if i < m - 1 and board[i + 1][j] == 'O':
                    union(index, index + n)
                if j < n - 1 and board[i][j + 1] == 'O':
                    union(index, index + 1)
        for i in range(m):
            for j in range(n):
                if i == 0 or i == m - 1 or j == 0 or j == n - 1:
                    border[find(i * n + j)] = True
        for i in range(m):
            for j in range(n):
                if board[i][j] == 'O' and not border[find(i * n + j)]:
                    board[i][j] = 'X'