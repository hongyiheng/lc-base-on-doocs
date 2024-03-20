class Solution:
    def minNonZeroProduct(self, p: int) -> int:
        MOD = int(1e9 + 7)
        k = (1 << p) - 1
        return k * pow(k - 1, k >> 1, MOD) % MOD