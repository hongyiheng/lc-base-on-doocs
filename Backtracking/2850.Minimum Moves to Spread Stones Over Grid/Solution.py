class Solution:
    def minimumMoves(self, grid: List[List[int]]) -> int:
        def dfs(i, u, v):
            if i == 9:
                return 0 if not v else inf
            if not v >> i & 1:
                return dfs(i + 1, u, v)
            ans = inf
            for j in range(9):
                if not u[j]:
                    continue
                u[j] -= 1
                cost = abs(j // 3 - i // 3) + abs(j % 3 - i % 3)
                ans = min(ans, dfs(i + 1, u, v ^ 1 << i) + cost)
                u[j] += 1
            return ans

        n = 3
        u, v = [0] * 9, 0
        for i in range(n):
            for j in range(n):
                if grid[i][j] > 1:
                    u[i * n + j] += grid[i][j] - 1
                elif not grid[i][j]:
                    v |= 1 << (i * n + j)
        return dfs(0, u, v)