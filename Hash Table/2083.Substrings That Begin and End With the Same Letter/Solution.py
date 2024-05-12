class Solution:
    def isSubstringPresent(self, s: str) -> bool:
        g = [[False] * 26 for _ in range(26)]
        for i in range(1, len(s)):
            g[ord(s[i - 1]) - ord('a')][ord(s[i]) - ord('a')] = True
        for i in range(len(s) - 2, -1, -1):
            if g[ord(s[i + 1]) - ord('a')][ord(s[i]) - ord('a')]:
                return True
        return False