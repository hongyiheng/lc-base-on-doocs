class Solution:
    def maximumDifference(self, nums: List[int]) -> int:
        last, n = -1, len(nums)
        ans = -1
        for i in range(n - 1, -1, -1):
            if last <= nums[i]:
                last = nums[i]
            else:
                ans = max(ans, last - nums[i])
        return ans