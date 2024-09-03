class Solution:
    def maxStrength(self, nums: List[int]) -> int:
        f0 = f1 = nums[0]
        for v in nums[1:]:
            t = f0
            f0 = max(f0, v, v * f0, v * f1)
            f1 = min(f1, v, v * t, v * f1)
        return max(f0, f1)