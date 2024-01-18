class Solution:
    def minLengthAfterRemovals(self, nums: List[int]) -> int:
        ans = n = len(nums)
        l, r = n // 2 - 1, n - 1
        while l >= 0 and r > n // 2 - 1:
            if nums[r] > nums[l]:
                r -= 1
                ans -= 2
            l -= 1
        return ans