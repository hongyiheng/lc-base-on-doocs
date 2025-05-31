class Solution:
    def snakesAndLadders(self, board: List[List[int]]) -> int:
        n = len(board)
        vis = {1}
        q = deque([1])
        ans = 0
        while q:
            for _ in range(len(q)):
                x = q.popleft()
                if x == n * n:
                    return ans
                for nx in range(x + 1, min(x + 6, n * n) + 1):
                    i, j = (nx - 1) // n, (nx - 1) % n
                    if i % 2:
                        j = n - 1 - j
                    i = n - 1 - i
                    v = nx if board[i][j] == -1 else board[i][j]
                    if v not in vis:
                        vis.add(v)
                        q.append(v)
            ans += 1
        return -1