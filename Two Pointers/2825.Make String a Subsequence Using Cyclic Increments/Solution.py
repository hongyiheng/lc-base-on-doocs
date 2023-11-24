class Solution:
    def canMakeSubsequence(self, str1: str, str2: str) -> bool:
        m, n = len(str1), len(str2)
        if m < n:
            return False
        j = 0
        for i in range(m):
            a, b = ord(str1[i]), ord(str2[j])
            if a == b or (a + 1) % 26 == b % 26:
                j += 1
            if j == n:
                return True
        return False