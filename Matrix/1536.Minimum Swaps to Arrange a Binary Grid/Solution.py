class Solution:
    def minSwaps(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        q = []
        for i in range(m):
            cnt = 0
            for j in range(n - 1, -1, -1):
                if grid[i][j]:
                    break
                cnt += 1
            q.append(cnt)
        ans = 0
        for i in range(n):
            if q[i] >= n - i - 1:
                continue
            j = i + 1
            while j < n:
                if q[j] >= n - i - 1:
                    break
                j += 1
            if j == n:
                return -1
            for k in range(j, i, -1):
                q[k], q[k - 1] = q[k - 1], q[k]
                ans += 1
        return ans

