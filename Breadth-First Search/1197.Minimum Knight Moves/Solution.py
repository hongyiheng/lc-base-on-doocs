class Solution:
    def minKnightMoves(self, i: int, j: int) -> int:
        M = 300
        dirs = [[2, 1], [2, -1], [-2, 1], [-2, -1], [1, 2], [1, -2], [-1, 2], [-1, -2]]
        q = deque()
        q.append([0, 0])
        vis = set()
        ans = 0
        while q:
            for _ in range(len(q)):
                x, y = q.popleft()
                if x == abs(i) and y == abs(j):
                    return ans
                for d in dirs:
                    nx, ny = x + d[0], y + d[1]
                    if nx < -2 or nx > M or ny < -2 or ny > M:
                        continue
                    if (nx, ny) in vis:
                        continue
                    vis.add((nx, ny))
                    q.append([nx, ny])
            ans += 1
        return ans
