class Solution:
    def minOperations(self, n: int) -> int:
        ans = i = 0
        while i * 2 + 1 < n:
            ans += n - (i * 2 + 1)
            i += 1
        return ans