class Solution:
    def minOperations(self, k: int) -> int:
        ans = k - 1
        for i in range(1, k):
            ans = min(ans, (i - 1) + (k - 1) // i)
        return ans
