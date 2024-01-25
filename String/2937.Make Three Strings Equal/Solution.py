class Solution:
    def findMinimumOperations(self, s1: str, s2: str, s3: str) -> int:
        n1, n2, n3 = len(s1), len(s2), len(s3)
        i, n = 0, min(n1, n2, n3)
        while i < n:
            if s1[i] != s2[i] or s2[i] != s3[i]:
                if not i:
                    return -1
                return n1 + n2 + n3 - 3 * i
            i += 1
        return n1 + n2 + n3 - 3 * n

