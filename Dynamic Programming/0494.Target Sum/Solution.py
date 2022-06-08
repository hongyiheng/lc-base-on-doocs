class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        n = len(nums)
        s = 0
        for v in nums:
            s += abs(v)
        if abs(target) > s:
            return 0
        f = [[0] * (2 * s + 1) for _ in range(n + 1)]
        f[0][s] = 1
        for i in range(1, n + 1):
            cur = nums[i - 1]
            for j in range(-s, s + 1):
                if j - cur + s >= 0:
                    f[i][j + s] += f[i - 1][j - cur + s]
                if j + cur + s <= 2 * s:
                    f[i][j + s] += f[i - 1][j + cur + s]
        return f[n][s + target]