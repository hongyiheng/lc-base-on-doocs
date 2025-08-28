class Solution:
    def sortMatrix(self, grid: List[List[int]]) -> List[List[int]]:
        m, n = len(grid), len(grid[0])
        g = defaultdict(list)
        for i, row in enumerate(grid):
            for j, v in enumerate(row):
                g[i - j].append(v)
        for k in g.keys():
            if k < 0:
                g[k].sort(reverse=True)
            else:
                g[k].sort()
        for i in range(m):
            for j in range(n):
                grid[i][j] = g[i - j].pop()
        return grid
