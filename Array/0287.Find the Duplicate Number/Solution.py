class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        i = 0
        while i < len(nums):
            v = nums[i]
            if i == v:
                i += 1
                continue
            if nums[i] == nums[v]:
                return v
            nums[i], nums[v] = nums[v], nums[i]
        return -1
