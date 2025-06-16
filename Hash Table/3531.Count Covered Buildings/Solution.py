class Solution:
    def countCoveredBuildings(self, n: int, buildings: List[List[int]]) -> int:
        ans = 0
        row, col = defaultdict(int), defaultdict(int)
        rowPos = [[0] * 2 for _ in range(n + 1)]
        colPos = [[0] * 2 for _ in range(n + 1)]
        for x, y in buildings:
            row[x] += 1
            col[y] += 1
            rowPos[x][0] = min((n if rowPos[x][0] == 0 else rowPos[x][0]), y)
            rowPos[x][1] = max(rowPos[x][1], y)
            colPos[y][0] = min((n if colPos[y][0] == 0 else colPos[y][0]), x)
            colPos[y][1] = max(colPos[y][1], x)
        for x, y in buildings:
            if y == rowPos[x][0] or y == rowPos[x][1]:
                continue
            if x == colPos[y][0] or x == colPos[y][1]:
                continue
            if row[x] >= 3 and col[y] >= 3:
                ans += 1
        return ans

