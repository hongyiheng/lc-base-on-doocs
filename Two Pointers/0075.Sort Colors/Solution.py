class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        l, r = 0, len(nums) - 1
        for i, v in enumerate(nums):
            if v == 0:
                l += 1
            elif v == 2:
                r -= 1
        for i in range(len(nums)):
            nums[i] = 0 if i < l else (2 if i > r else 1)
