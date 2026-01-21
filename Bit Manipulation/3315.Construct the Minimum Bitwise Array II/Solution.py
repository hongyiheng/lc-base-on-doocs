class Solution:
    def minBitwiseArray(self, nums: List[int]) -> List[int]:
        def f(x):
            ans = -1
            for i in range(31):
                if (x >> i) & 1:
                    m = x & ~(1 << i)
                    if (m | (m + 1)) == x or ((m - 1) | m) == x:
                        if ans == -1 or m < ans:
                            ans = m
            return ans

        return [f(v) for v in nums]