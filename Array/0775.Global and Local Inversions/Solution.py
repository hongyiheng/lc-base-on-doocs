class Solution:
    def isIdealPermutation(self, nums: List[int]) -> bool:
        i, n = 0, len(nums)
        mx = float('-inf')
        while i < n:
            if i < n - 1 and nums[i] > nums[i + 1]:
                if mx > nums[i + 1]:
                    return False
                mx = nums[i]
                i += 1
            else:
                if mx > nums[i]:
                    return False
                mx = nums[i]
            i += 1
        return True
