class Solution:
    def maximumSubsequenceCount(self, text: str, pattern: str) -> int:
        a = b = 0
        for c in text:
            if c == pattern[0]:
                a += 1
            if c == pattern[1]:
                b += 1
        ans = max(a, b)
        for c in text:
            if c == pattern[1]:
                b -= 1
            if c == pattern[0]:
                ans += b
        return ans


