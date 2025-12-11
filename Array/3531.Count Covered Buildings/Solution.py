class Solution:
    def countCoveredBuildings(self, n: int, buildings: List[List[int]]) -> int:
        row_max = [0] * (n + 1)
        row_min = [n] * (n + 1)
        col_max = [0] * (n + 1)
        col_min = [n] * (n + 1)
        for x, y in buildings:
            row_max[y] = max(row_max[y], x)
            row_min[y] = min(row_min[y], x)
            col_max[x] = max(col_max[x], y)
            col_min[x] = min(col_min[x], y)
        ans = 0
        for x, y in buildings:
            if row_min[y] < x < row_max[y] and col_min[x] < y < col_max[x]:
                ans += 1
        return ans