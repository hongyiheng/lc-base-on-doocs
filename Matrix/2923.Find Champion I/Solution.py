class Solution:
    def findChampion(self, grid: List[List[int]]) -> int:
        n = len(grid)
        for j in range(n):
            win = True
            for i in range(n):
                if grid[i][j]:
                    win = False
                    break
            if win:
                return j
        return 0