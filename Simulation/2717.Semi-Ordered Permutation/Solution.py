class Solution:
    def semiOrderedPermutation(self, nums: List[int]) -> int:
        n = len(nums)
        x = y = -1
        for i, v in enumerate(nums):
            if v == 1:
                x = i
            elif v == n:
                y = i
        return x + n - y - 1 if x < y else x + n - y - 2