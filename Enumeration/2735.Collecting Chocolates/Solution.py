class Solution:
    def minCost(self, nums: List[int], x: int) -> int:
        n = len(nums)
        f = [[0] * n for _ in range(n)]
        ans = inf
        for i in range(n):
            s = i * x
            for j in range(n):
                f[i][j] = nums[(i + j) % n]
                if i > 0:
                    f[i][j] = min(f[i][j], f[i - 1][j])
                s += f[i][j]
            ans = min(ans, s)
        return ans