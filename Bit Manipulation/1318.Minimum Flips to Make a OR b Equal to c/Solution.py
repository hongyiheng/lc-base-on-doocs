class Solution:
    def minFlips(self, a: int, b: int, c: int) -> int:
        ans = 0
        for i in range(32):
            if c >> i & 1 == 0:
                ans += (a >> i & 1) + (b >> i & 1)
            else:
                ans += 1 if (a | b) >> i & 1 == 0 else 0
        return ans
