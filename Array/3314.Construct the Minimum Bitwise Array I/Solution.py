class Solution:
    def minBitwiseArray(self, nums: List[int]) -> List[int]:
        def f(x):
            for i in range(x + 1):
                v = 0
                for j in range(11):
                    if i >> j & 1 or (i + 1) >> j & 1:
                        v |= 1 << j
                if v == x:
                    return i
            return -1

        return [f(v) for v in nums]