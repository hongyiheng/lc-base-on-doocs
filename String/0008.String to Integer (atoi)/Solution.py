class Solution:
    def myAtoi(self, s: str) -> int:
        while s and s[0] == ' ':
            s = s[1:]
        if not s:
            return 0
        neg = False
        if s[0] in ('+', '-'):
            neg = s[0] == '-'
            s = s[1:]
        ans = 0
        for i in range(len(s)):
            if ans >= 1 << 31 or not s[i].isdigit():
                break
            ans = ans * 10 + int(s[i])
        return max(-ans, -(1 << 31)) if neg else min(ans, (1 << 31) - 1)