class Solution:
    def minimumOperationsToWriteY(self, grid: List[List[int]]) -> int:
        n, mid = len(grid), len(grid) // 2
        cnt = [[0] * 3 for _ in range(2)]
        for i in range(n):
            for j in range(n):
                if i <= mid:
                    if i == j or j == n - i - 1:
                        cnt[0][grid[i][j]] += 1
                    else:
                        cnt[1][grid[i][j]] += 1
                else:
                    if j == mid:
                        cnt[0][grid[i][j]] += 1
                    else:
                        cnt[1][grid[i][j]] += 1
        ans = n * n
        for i in range(3):
            for j in range(3):
                if i == j:
                    continue
                v = cnt[0][(i + 1) % 3] + cnt[0][(i + 2) % 3] + cnt[1][(j + 1) % 3] + cnt[1][(j + 2) % 3]
                ans = min(ans, v)
        return ans
