class Solution:
    def maxArrayValue(self, nums: List[int]) -> int:
        ans = nums[0]
        for i in range(len(nums) - 2, -1, -1):
            if nums[i] <= nums[i + 1]:
                nums[i] += nums[i + 1]
            ans = max(ans, nums[i])
        return ans