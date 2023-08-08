class Solution:
    def maxAbsoluteSum(self, nums: List[int]) -> int:
        n = len(nums)
        pos = neg = ans = 0
        for i in range(n):
            pos = max(pos + nums[i], 0)
            neg = min(neg + nums[i], 0)
            ans = max(pos, -neg, ans)
        return ans