class Solution:
    def maxSum(self, nums: List[int]) -> int:
        s = set([v for v in nums if v >= 0])
        return sum(s) if s else max(nums)
