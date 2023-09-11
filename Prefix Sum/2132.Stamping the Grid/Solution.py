class Solution:
    def possibleToStamp(self, grid: List[List[int]], stampHeight: int, stampWidth: int) -> bool:
        m, n = len(grid), len(grid[0])
        s = [[0] * (n + 1) for _ in range(m + 1)]
        diff = [[0] * (n + 1) for _ in range(m + 1)]
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                s[i][j] = s[i][j - 1] + s[i - 1][j] - s[i - 1][j - 1] + grid[i - 1][j - 1]

        for i in range(m + 1):
            for j in range(n + 1):
                x, y = i + stampHeight, j + stampWidth
                if x <= m and y <= n and s[x][y] - s[i][y] - s[x][j] + s[i][j] == 0:
                    diff[i][j] += 1
                    diff[x][j] -= 1
                    diff[i][y] -= 1
                    diff[x][y] += 1

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + diff[i - 1][j - 1]
                if s[i][j] == 0 and grid[i - 1][j - 1] == 0:
                    return False
        return True