class Solution:
    def isOneEditDistance(self, s: str, t: str) -> bool:
        n, m = len(s), len(t)
        if abs(n - m) > 1:
            return False
        i = j = diff = 0
        while i < n and j < m:
            if s[i] == t[j]:
                i += 1
                j += 1
            else:
                diff += 1
                if n > m:
                    i += 1
                elif m > n:
                    j += 1
                else:
                    i += 1
                    j += 1
        return diff == 1 or (diff == 0 and abs(m - n) == 1)
