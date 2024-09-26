class Solution:
    def differenceOfSum(self, nums: List[int]) -> int:
        a = b = 0
        for v in nums:
            a += v
            while v:
                b += v % 10
                v //= 10
        return abs(a - b)
