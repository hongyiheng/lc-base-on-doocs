class Solution:
    def removeAlmostEqualCharacters(self, word: str) -> int:
        i, n = 1, len(word)
        ans = 0
        while i < n:
            c = ord(word[i - 1])
            s = {c, c + 1, c - 1}
            if ord(word[i]) in s:
                ans += 1
                i += 1
            i += 1
        return ans