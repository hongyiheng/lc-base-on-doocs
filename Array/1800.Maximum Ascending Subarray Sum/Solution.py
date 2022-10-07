class Solution:
    def maxAscendingSum(self, nums: List[int]) -> int:
        ans = cur = nums[0]
        for i in range(1, len(nums)):
            if nums[i] > nums[i - 1]:
                cur += nums[i]
            else:
                ans = max(cur, ans)
                cur = nums[i]
        return max(ans, cur)
