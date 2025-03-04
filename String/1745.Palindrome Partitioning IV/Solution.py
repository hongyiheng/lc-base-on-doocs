class Solution:
    def checkPartitioning(self, s: str) -> bool:
        n = len(s)
        for i in range(1, n):
            if s[:i] != s[:i][::-1]:
                continue
            for j in range(i + 1, n):
                mid = s[i:j]
                suff = s[j:]
                if mid == mid[::-1] and suff == suff[::-1]:
                    return True
        return False