class Solution:
    def countKeyChanges(self, s: str) -> int:
        s = s.lower()
        ans = 0
        for i in range(1, len(s)):
            last, cur = ord(s[i - 1]), ord(s[i])
            if last % 26 != cur % 26:
                ans += 1
        return ans
