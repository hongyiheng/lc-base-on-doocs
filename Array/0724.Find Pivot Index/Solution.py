class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        s = sum(nums)
        t = 0
        for i, v in enumerate(nums):
            if t == (s - v) / 2:
                return i
            t += v
        return -1
