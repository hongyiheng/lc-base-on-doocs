class Solution:
    def minPartitions(self, n: str) -> int:
        ans = 0
        for c in list(n):
            ans = max(ans, ord(c) - ord('0'))
        return ans