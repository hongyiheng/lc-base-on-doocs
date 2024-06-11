class Solution:
    def countBattleships(self, board: List[List[str]]) -> int:
        def find(x):
            if p[x] != x:
                p[x] = find(x)
            return p[x]

        def union(a, b):
            p[find(b)] = find(a)

        m, n = len(board), len(board[0])
        p = [i for i in range(m * n)]
        for i in range(m):
            for j in range(n):
                if board[i][j] == '.':
                    continue
                if i and board[i - 1][j] == 'X':
                    union(i * n + j, (i - 1) * n + j)
                if j and board[i][j - 1] == 'X':
                    union(i * n + j, i * n + j - 1)
        ans = 0
        for i in range(m):
            for j in range(n):
                if board[i][j] == 'X' and p[i * n + j] == i * n + j:
                    ans += 1
        return ans
