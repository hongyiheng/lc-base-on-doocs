class Solution:
    def smallestNumber(self, n: int) -> int:
        ans = 1
        while ans < n:
            ans = ans << 1 | 1
        return ans

