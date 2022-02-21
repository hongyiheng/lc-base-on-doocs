class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        m, n = len(board), len(board[0])
        vis = [[False] * n for _ in range(m)]
        dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]]

        def dfs(x, y, ne):
            nonlocal word, board, dirs, vis
            c = word[ne]
            if board[x][y] != c:
                return False
            if ne == len(word) - 1:
                return True
            for d in dirs:
                nx, ny = x + d[0], y + d[1]
                if nx < 0 or nx >= m or ny < 0 or ny >= n:
                    continue
                if vis[nx][ny]:
                    continue
                vis[nx][ny] = True
                if dfs(nx, ny, ne + 1):
                    return True
                vis[nx][ny] = False
            return False


        root = word[0]
        for i in range(m):
            for j in range(n):
                if board[i][j] == root:
                    vis[i][j] = True
                    if dfs(i, j, 0):
                        return True
                    vis[i][j] = False
        return False
