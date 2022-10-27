class Solution:
    def arraySign(self, nums: List[int]) -> int:
        pos = True
        for v in nums:
            if v < 0:
                pos = not pos
            if v == 0:
                return 0
        return 1 if pos else -1
