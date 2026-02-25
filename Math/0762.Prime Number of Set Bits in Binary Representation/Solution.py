class Solution:
    def countPrimeSetBits(self, left: int, right: int) -> int:
        ans = 0
        primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31}
        for v in range(left, right + 1):
            if v.bit_count() in primes:
                ans += 1
        return ans