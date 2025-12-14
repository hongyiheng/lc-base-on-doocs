class Solution:
    def splitArray(self, nums: List[int]) -> int:
        n = len(nums)
        if n <= 2:
            return abs(sum(nums))
        primes = [False] * n
        primes[0] = primes[1] = True
        for i in range(2, n):
            if not primes[i]:
                for j in range(i * i, n, i):
                    primes[j] = True
        return abs(sum([v if primes[i] else -v for i, v in enumerate(nums)]))