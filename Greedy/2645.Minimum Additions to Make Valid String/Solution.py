class Solution:
    def addMinimum(self, word: str) -> int:
        t = ans = 0
        i, n = 0, len(word)
        while i < n:
            v = ord(word[i]) - ord('a')
            if v != t:
                ans += 1
            else:
                i += 1
            t = (t + 1) % 3
        return ans + (3 - t) % 3
