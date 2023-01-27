class Solution:
    def greatestLetter(self, s: str) -> str:
        cs = [[False] * 2 for _ in range(26)]
        for c in s:
            if 'a' <= c <= 'z':
                cs[ord(c) - ord('a')][0] = True
            else:
                cs[ord(c) - ord('A')][1] = True
        for i in range(25, -1, -1):
            if cs[i][0] and cs[i][1]:
                return chr(ord('A') + i)
        return ""