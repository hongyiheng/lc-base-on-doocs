class Solution:
    def lastSubstring(self, s: str) -> str:
        i, j, k = 0, 1, 0
        n = len(s)
        while j + k < n:
            if s[i + k] == s[j + k]:
                k += 1
            elif s[i + k] < s[j + k]:
                i += k + 1
                if i >= j:
                    j = i + 1
                k = 0
            else:
                j += k + 1
                k = 0
        return s[i:]
