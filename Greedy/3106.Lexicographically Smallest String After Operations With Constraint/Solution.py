class Solution:
    def getSmallestString(self, s: str, k: int) -> str:
        cs = list(s)
        for i, c in enumerate(cs):
            d = ord(c) - ord('a')
            d = min(26 - d, d)
            if k >= d:
                k -= d
                cs[i] = 'a'
            else:
                cs[i] = chr(ord(c) - k)
                break
        return "".join(cs)