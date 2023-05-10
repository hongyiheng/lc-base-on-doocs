class Solution:
    def queryString(self, s: str, n: int) -> bool:
        if n > 1 << 11:
            return False
        for i in range(1, n + 1):
            if str(bin(i))[2:] not in s:
                return False
        return True
