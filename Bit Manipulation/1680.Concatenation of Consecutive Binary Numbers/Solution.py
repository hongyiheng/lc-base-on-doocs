class Solution:
    def concatenatedBinary(self, n: int) -> int:
        mod = int(1e9 + 7)
        ans = length = 0
        for i in range(1, n + 1):
            if (i & (i - 1)) == 0:
                length += 1
            ans = (ans * (1 << length) + i) % mod
        return ans


