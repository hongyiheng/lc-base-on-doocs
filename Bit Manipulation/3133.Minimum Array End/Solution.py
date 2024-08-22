class Solution:
    def minEnd(self, n: int, x: int) -> int:
        n -= 1
        j = 0
        for i in range(64):
            if x >> i & 1 == 0:
                if n >> j & 1:
                    x |= 1 << i
                j += 1
        return x