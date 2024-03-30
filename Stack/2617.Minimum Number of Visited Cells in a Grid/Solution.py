class Solution:
    def minimumVisitedCells(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        dist = [[inf] * n for _ in range(m)]
        rows = [[] for _ in range(m)]
        cols = [[] for _ in range(n)]
        dist[0][0] = 1
        for i in range(m):
            for j in range(n):
                row, col = rows[i], cols[j]
                while row and j > grid[i][row[0][1]] + row[0][1]:
                    heapq.heappop(row)
                while col and i > grid[col[0][1]][j] + col[0][1]:
                    heapq.heappop(col)
                if row:
                    dist[i][j] = min(dist[i][j], dist[i][row[0][1]] + 1)
                if col:
                    dist[i][j] = min(dist[i][j], dist[col[0][1]][j] + 1)
                heapq.heappush(row, [dist[i][j], j])
                heapq.heappush(col, [dist[i][j], i])
        return -1 if dist[-1][-1] == inf else dist[-1][-1]
