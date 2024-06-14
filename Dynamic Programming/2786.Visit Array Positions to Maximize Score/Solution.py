class Solution:
    def maxScore(self, nums: List[int], x: int) -> int:
        n = len(nums)
        f = [[0] * 2 for _ in range(n + 1)]
        f[0][nums[0] & 1 ^ 1] -= x
        for i in range(1, n + 1):
            v = nums[i - 1]
            f[i] = f[i - 1]
            f[i][v & 1] = max(f[i - 1][v & 1] + v, f[i - 1][v & 1 ^ 1] - x + v)
        return max(f[n])