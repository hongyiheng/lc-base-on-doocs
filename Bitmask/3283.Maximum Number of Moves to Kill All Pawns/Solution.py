class Solution:
    def maxMoves(self, kx: int, ky: int, positions: List[List[int]]) -> int:
        @cache
        def dfs(x, y, mask):
            nonlocal n
            if mask == (1 << n) - 1:
                return 0
            ans = 0
            if mask.bit_count() % 2 == 1:
                for i, pos in enumerate(positions):
                    if not mask >> i & 1:
                        ans = max(ans, dfs(pos[0], pos[1], mask | 1 << i) + dis[i][x][y])
            else:
                ans = inf
                for i, pos in enumerate(positions):
                    if not mask >> i & 1:
                        ans = min(ans, dfs(pos[0], pos[1], mask | 1 << i) + dis[i][x][y])
            return ans

        positions = [[kx, ky]] + positions
        n = len(positions)
        dis = [[[-1] * 50 for _ in range(50)] for _ in range(n)]
        for i, pos in enumerate(positions):
            q = deque([pos])
            step = 0
            while q:
                step += 1
                for _ in range(len(q)):
                    x, y = q.popleft()
                    for d in [[1, 2], [1, -2], [2, 1], [2, -1], [-2, -1], [-2, 1], [-1, 2], [-1, -2]]:
                        nx, ny = x + d[0], y + d[1]
                        if nx < 0 or nx >= 50 or ny < 0 or ny >= 50:
                            continue
                        if dis[i][nx][ny] != -1:
                            continue
                        dis[i][nx][ny] = step
                        q.append([nx, ny])
        return dfs(kx, ky, 1)
