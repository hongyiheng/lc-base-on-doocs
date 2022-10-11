class Solution:
    def areAlmostEqual(self, s1: str, s2: str) -> bool:
        if s1 == s2:
            return True
        a = b = -1
        for i in range(len(s1)):
            if s1[i] != s2[i]:
                if a == -1:
                    a = i
                elif b == -1:
                    b = i
                else:
                    return False
        return s1[a] == s2[b] and s1[b] == s2[a]
