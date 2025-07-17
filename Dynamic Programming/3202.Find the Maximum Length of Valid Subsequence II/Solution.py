class Solution:
    def maximumLength(self, nums: List[int], k: int) -> int:
        f = [[0] * k for _ in range(k)]
        for i, v in enumerate(nums):
            x = v % k
            for j in range(k):
                f[j][x] = max(f[j][x], f[x][j] + 1)
        ans = 0
        for r in f:
            ans = max(ans, max(r))
        return ans

