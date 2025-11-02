class Solution:
    def countUnguarded(self, m: int, n: int, guards: List[List[int]], walls: List[List[int]]) -> int:
        ans = m * n
        guards_set, walls_set = set(), set()
        q = deque()
        for g in guards:
            q.append(g)
            guards_set.add(g[0] * n + g[1])
            ans -= 1
        for w in walls:
            walls_set.add(w[0] * n + w[1])
            ans -= 1
        dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        vis = [[0] * n for _ in range(m)]
        while q:
            x, y = q.pop()
            for i, d in enumerate(dirs):
                nx, ny = x, y
                while True:
                    nx += d[0]
                    ny += d[1]
                    if nx < 0 or nx >= m or ny < 0 or ny >= n:
                        break
                    idx = nx * n + ny
                    if idx in guards_set or idx in walls_set:
                        break
                    if vis[nx][ny] & (1 << i) == 0:
                        if vis[nx][ny] == 0:
                            ans -= 1
                        vis[nx][ny] |= (1 << i)
        return ans