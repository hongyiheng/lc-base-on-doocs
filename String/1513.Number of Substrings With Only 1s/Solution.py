class Solution:
    def numSub(self, s: str) -> int:
        mod = int(1e9 + 7)
        ans = d = 0
        for v in list(s):
            if v == '1':
                d += 1
            else:
                d = 0
            ans = (ans + d) % mod
        return ans