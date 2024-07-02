class Solution:
    def maximumPrimeDifference(self, nums: List[int]) -> int:
        def get_primes(n):
            primes = [False] * n
            for i in range(2, n):
                if primes[i]:
                    continue
                for j in range(i * i, n, i):
                    primes[j] = True
            primes[0] = primes[1] = True
            return primes

        primes = get_primes(110)
        n = len(nums)
        l, r = 0, n - 1
        while l < n:
            if not primes[nums[l]]:
                break
            l += 1
        while r > 0:
            if not primes[nums[r]]:
                break
            r -= 1
        return r - l