class Solution:
    def isTrionic(self, nums: List[int]) -> bool:
        n = len(nums)
        i = 1
        while i < n and nums[i - 1] < nums[i]:
            i += 1
        if i == 1:
            return False
        j = i
        while i < n and nums[i - 1] > nums[i]:
            i += 1
        if i == j or i == n:
            return False
        while i < n and nums[i - 1] < nums[i]:
            i += 1
        return i == n