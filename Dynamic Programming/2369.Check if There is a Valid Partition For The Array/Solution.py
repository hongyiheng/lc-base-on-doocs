class Solution:
    def validPartition(self, nums: List[int]) -> bool:
        n = len(nums)
        f = [True] + [False] * n
        for i in range(1, n + 1):
            a = i > 1 and f[i - 2] and nums[i - 1] == nums[i - 2]
            b = i > 2 and f[i - 3] and nums[i - 1] == nums[i - 2] == nums[i - 3]
            c = i > 2 and f[i - 3] and nums[i - 1] - nums[i - 2] == nums[i - 2] - nums[i - 3] == 1
            f[i] = a or b or c
        return f[n]