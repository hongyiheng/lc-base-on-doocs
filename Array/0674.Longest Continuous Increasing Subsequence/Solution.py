class Solution:
    def findLengthOfLCIS(self, nums: List[int]) -> int:
        ans = cur = 1
        for i in range(1, len(nums)):
            if nums[i] > nums[i - 1]:
                cur += 1
            else:
                cur = 1
            ans = max(ans, cur)
        return ans

