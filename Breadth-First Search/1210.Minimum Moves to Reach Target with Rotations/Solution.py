class Solution:
    def minimumMoves(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        q = deque()
        q.append((0, 1, 0))
        vis = set()
        vis.add((0, 1, 0))
        ans = 0
        while q:
            for _ in range(len(q)):
                x, y, s = q.popleft()
                if x == m - 1 and y == n - 1 and s == 0:
                    return ans
                # 水平
                if s == 0:
                    # 右
                    if y + 1 < n and grid[x][y + 1] == 0:
                        if (x, y + 1, 0) not in vis:
                            q.append((x, y + 1, 0))
                            vis.add((x, y + 1, 0))
                    # 下
                    if x + 1 < m and grid[x + 1][y] == 0 and grid[x + 1][y - 1] == 0:
                        if (x + 1, y, 0) not in vis:
                            q.append((x + 1, y, 0))
                            vis.add((x + 1, y, 0))
                        # 顺 90
                        if (x + 1, y - 1, 1) not in vis:
                            q.append((x + 1, y - 1, 1))
                            vis.add((x + 1, y - 1, 1))
                # 垂直
                else:
                    # 右
                    if y + 1 < n and grid[x][y + 1] == 0 and grid[x - 1][y + 1] == 0:
                        if (x, y + 1, 1) not in vis:
                            q.append((x, y + 1, 1))
                            vis.add((x, y + 1, 1))
                        # 逆 90
                        if (x - 1, y + 1, 0) not in vis:
                            q.append((x - 1, y + 1, 0))
                            vis.add((x - 1, y + 1, 0))
                    # 下
                    if x + 1 < m and grid[x + 1][y] == 0:
                        if (x + 1, y, 1) not in vis:
                            q.append((x + 1, y, 1))
                            vis.add((x + 1, y, 1))
            ans += 1
        return -1