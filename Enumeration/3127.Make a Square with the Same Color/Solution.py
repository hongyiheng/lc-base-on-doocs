class Solution:
    def canMakeSquare(self, grid: List[List[str]]) -> bool:
        for i in range(0, 2):
            for j in range(0, 2):
                cnt = 1 if grid[i][j] == 'W' else 0
                cnt += 1 if grid[i + 1][j] == 'W' else 0
                cnt += 1 if grid[i][j + 1] == 'W' else 0
                cnt += 1 if grid[i + 1][j + 1] == 'W' else 0
                if cnt >= 3 or cnt <= 1:
                    return True
        return False
