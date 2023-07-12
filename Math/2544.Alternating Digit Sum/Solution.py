class Solution:
    def alternateDigitSum(self, n: int) -> int:
        ans = 0
        for i, v in enumerate(str(n)):
            ans += -int(v) if i & 1 else int(v)
        return ans