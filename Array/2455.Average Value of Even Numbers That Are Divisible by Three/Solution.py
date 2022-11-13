class Solution:
    def averageValue(self, nums: List[int]) -> int:
        s = c = 0
        for v in nums:
            if v % 6 == 0:
                s += v
                c += 1
        return s // c if c else 0
