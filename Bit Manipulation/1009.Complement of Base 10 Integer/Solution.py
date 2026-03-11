class Solution:
    def bitwiseComplement(self, n: int) -> int:
        if not n:
            return 1
        ans = i = 0
        while n:
            if n & 1 == 0:
                ans += 1 << i
            i += 1
            n >>= 1
        return ans