class Solution:
    def largestLocal(self, grid: List[List[int]]) -> List[List[int]]:
        def get_max(x, y):
            nonlocal grid
            ans = 0
            for i in range(x - 1, x + 2):
                for j in range(y - 1, y + 2):
                    ans = max(ans, grid[i][j])
            return ans

        n = len(grid)
        ans = []
        for i in range(1, n - 1):
            r = []
            for j in range(1, n - 1):
                r.append(get_max(i, j))
            ans.append(r)
        return ans