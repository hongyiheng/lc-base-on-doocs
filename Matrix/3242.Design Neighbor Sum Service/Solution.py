class NeighborSum:

    def __init__(self, grid: List[List[int]]):
        self.grid = grid

    def adjacentSum(self, value: int) -> int:
        m, n = len(self.grid), len(self.grid[0])
        for i in range(m):
            for j in range(n):
                if self.grid[i][j] != value:
                    continue
                ans = 0
                if i > 0:
                    ans += self.grid[i - 1][j]
                if i < m - 1:
                    ans += self.grid[i + 1][j]
                if j > 0:
                    ans += self.grid[i][j - 1]
                if j < n - 1:
                    ans += self.grid[i][j + 1]
                return ans

    def diagonalSum(self, value: int) -> int:
        m, n = len(self.grid), len(self.grid[0])
        for i in range(m):
            for j in range(n):
                if self.grid[i][j] != value:
                    continue
                ans = 0
                if i > 0:
                    if j > 0:
                        ans += self.grid[i - 1][j - 1]
                    if j < n - 1:
                        ans += self.grid[i - 1][j + 1]
                if i < m - 1:
                    if j > 0:
                        ans += self.grid[i + 1][j - 1]
                    if j < n - 1:
                        ans += self.grid[i + 1][j + 1]
                return ans

# Your NeighborSum object will be instantiated and called as such:
# obj = NeighborSum(grid)
# param_1 = obj.adjacentSum(value)
# param_2 = obj.diagonalSum(value)