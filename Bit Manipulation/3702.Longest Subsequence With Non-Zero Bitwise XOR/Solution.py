class Solution:
    def longestSubsequence(self, nums: List[int]) -> int:
        n = len(nums)
        s = 0
        for num in nums:
            s ^= num
        if s != 0:
            return n
        zero = any(num != 0 for num in nums)
        if zero:
            return n - 1
        return 0