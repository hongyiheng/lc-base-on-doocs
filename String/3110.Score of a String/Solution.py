class Solution:
    def scoreOfString(self, s: str) -> int:
        ans = 0
        last = ord(s[0])
        for i in range(1, len(s)):
            v = ord(s[i])
            ans += abs(last - v)
            last = v
        return ans
