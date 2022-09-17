class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        cnt = Counter(nums)
        for i in range(len(nums)):
            if i < cnt.get(0, 0):
                nums[i] = 0
            elif i < cnt.get(0, 0) + cnt.get(1, 0):
                nums[i] = 1
            else:
                nums[i] = 2