class Solution:
    def rangeBitwiseAnd(self, left: int, right: int) -> int:
        ans = 0
        for i in range(30, -1, -1):
            if left >= (1 << i) and right < (1 << (i + 1)):
                ans += (1 << i)
                left -= (1 << i)
                right -= (1 << i)
        return ans
