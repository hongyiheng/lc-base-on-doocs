class Solution:
    def maximumLength(self, nums: List[int]) -> int:
        f00 = f01 = f10 = f11 = 0
        for v in nums:
            if v % 2:
                f11 += 1
                f10 = f01 + 1
            else:
                f00 += 1
                f01 = f10 + 1
        return max(f00, f01, f10, f11)

