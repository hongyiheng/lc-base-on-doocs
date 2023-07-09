class Solution:
    def distinctPrimeFactors(self, nums: List[int]) -> int:
        M = 1010
        primes = [False] * M
        for i in range(2, M):
            if not primes[i]:
                for j in range(i * i, M, i):
                    primes[j] = True
        ans = set()
        for v in nums:
            for i in range(2, M):
                if i > v:
                    break
                if not primes[i] and v % i == 0:
                    ans.add(i)
                    while v % i == 0:
                        v //= i
            if v > 1:
                ans.add(v)
        return len(ans)