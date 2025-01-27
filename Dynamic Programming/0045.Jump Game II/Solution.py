class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return 0
        f = [inf] * n
        f[0] = 0
        for i in range(n):
            v = nums[i]
            for j in range(i + 1, min(i + v + 1, n)):
                f[j] = min(f[j], f[i] + 1)
        return f[-1]
        