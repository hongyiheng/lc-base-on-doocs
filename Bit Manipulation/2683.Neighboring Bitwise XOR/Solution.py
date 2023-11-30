class Solution:
    def doesValidArrayExist(self, derived: List[int]) -> bool:
        n = len(derived)
        if n == 1:
            return derived[0] == 0
        f1, f2 = 0, 1
        for i in range(n - 1):
            if derived[i] == 1:
                f1 ^= 1
                f2 ^= 1
        return f1 ^ 0 == derived[-1] or f2 ^ 1 == derived[-1]