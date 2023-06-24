class Solution:
    def maxStrength(self, nums: List[int]) -> int:
        mx = mi = ans = nums[0]
        for i in range(1, len(nums)):
            v, tmp = nums[i], mx
            mx = max(mx, v, v * mx, v * mi)
            mi = min(mi, v, v * tmp, v * mi)
        return max(mx, mi)