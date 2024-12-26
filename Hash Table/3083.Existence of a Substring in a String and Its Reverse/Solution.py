class Solution:
    def isSubstringPresent(self, s: str) -> bool:
        n = len(s)
        cs = set()
        for i in range(1, n):
            v = (ord(s[i - 1]) - ord('a')) * 26 + ord(s[i]) - ord('a')
            cs.add(v)
        for i in range(n - 2, -1, -1):
            v = (ord(s[i + 1]) - ord('a')) * 26 + ord(s[i]) - ord('a')
            if v in cs:
                return True
        return False