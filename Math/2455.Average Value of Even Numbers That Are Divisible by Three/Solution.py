class Solution:
    def averageValue(self, nums: List[int]) -> int:
        val = cnt = 0
        for v in nums:
            if v % 2 == 0 and v % 3 == 0:
                val += v
                cnt += 1
        return 0 if cnt == 0 else val // cnt
