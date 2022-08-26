class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        f = s = 0
        for v in nums:
            if v >= f:
                s = f
                f = v
            elif v > s:
                s = v
        return (f - 1) * (s - 1)