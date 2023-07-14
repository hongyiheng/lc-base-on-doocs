class Solution:
    def maximumCount(self, nums: List[int]) -> int:
        n = len(nums)
        l, r = 0, n - 1
        while l < r:
            mid = (l + r) >> 1
            if nums[mid] < 0:
                l = mid + 1
            else:
                r = mid
        if nums[r] < 0:
            return n
        while r < n and nums[r] == 0:
            r += 1
        return max(l, n - r)