class Solution:
    def hasTrailingZeros(self, nums: List[int]) -> bool:
        zero = 0
        for v in nums:
            if v & 1 == 0:
                zero += 1
        return zero >= 2