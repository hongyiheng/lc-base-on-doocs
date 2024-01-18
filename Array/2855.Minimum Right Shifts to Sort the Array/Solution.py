class Solution:
    def minimumRightShifts(self, nums: List[int]) -> int:
        i, n = 1, len(nums)
        while i < n:
            if nums[i] < nums[i - 1]:
                break
            i += 1
        for j in range(1, n):
            if nums[(i + j) % n] < nums[(i + j - 1) % n]:
                return -1
        return n - i