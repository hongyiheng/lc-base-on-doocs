class Solution:
    def maxAlternatingSum(self, nums: List[int]) -> int:
        n = len(nums)
        f0, f1 = nums[0], 0
        for i in range(1, n):
            tmp = f0
            f0 = max(f0, f1 + nums[i])
            f1 = max(f1, f0 - nums[i])
        return max(f0, f1)