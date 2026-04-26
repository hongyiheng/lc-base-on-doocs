from typing import List

class Solution:
    def containsCycle(self, grid: List[List[str]]) -> bool:
        def dfs(x: int, y: int, px: int, py: int) -> bool:
            visited[x][y] = True
            for dx, dy in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
                nx, ny = x + dx, y + dy
                if nx < 0 or nx >= m or ny < 0 or ny >= n:
                    continue
                if grid[nx][ny] != grid[x][y]:
                    continue
                if nx == px and ny == py:
                    continue
                if visited[nx][ny]:
                    return True
                if dfs(nx, ny, x, y):
                    return True

            return False

        m, n = len(grid), len(grid[0])
        visited = [[False] * n for _ in range(m)]
        for i in range(m):
            for j in range(n):
                if not visited[i][j]:
                    if dfs(i, j, -1, -1):
                        return True
        return False