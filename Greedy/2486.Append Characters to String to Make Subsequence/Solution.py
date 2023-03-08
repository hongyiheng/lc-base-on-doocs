class Solution:
    def appendCharacters(self, s: str, t: str) -> int:
        m = len(t)
        ans, idx = m, 0
        for i, c in enumerate(t):
            j = s.find(c, idx)
            if j == -1:
                break
            else:
                ans -= 1
                idx = j + 1
        return ans
