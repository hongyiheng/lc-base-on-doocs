class Solution:
    def hasAlternatingBits(self, n: int) -> bool:
        m = n ^ (n >> 1)
        return m & (m + 1) == 0