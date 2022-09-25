class Solution:
    def longestContinuousSubstring(self, s: str) -> int:
        ans = start = 0
        for i in range(1, len(s)):
            if ord(s[i]) - ord(s[i - 1]) == 1:
                continue
            ans = max(ans, i - start)
            start = i
        return max(ans, len(s) - start)
