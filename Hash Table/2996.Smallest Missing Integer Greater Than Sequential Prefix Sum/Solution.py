class Solution:
    def missingInteger(self, nums: List[int]) -> int:
        x = nums[0]
        for i in range(1, len(nums)):
            if nums[i] != nums[i - 1] + 1:
                break
            x += nums[i]
        while x in nums:
            x += 1
        return x
