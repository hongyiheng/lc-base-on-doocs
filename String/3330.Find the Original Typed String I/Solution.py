class Solution:
    def possibleStringCount(self, word: str) -> int:
        ans, msk = 1, 0
        for c in word:
            v = ord(c) - ord('a')
            if msk >> v & 1:
                ans += 1
            msk = 1 << v
        return ans
