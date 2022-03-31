class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        n = len(nums)
        ans = last = nums[0]
        for i in range(1, n):
            last = max(nums[i], nums[i] + last)
            ans = max(last, ans)
        return ans