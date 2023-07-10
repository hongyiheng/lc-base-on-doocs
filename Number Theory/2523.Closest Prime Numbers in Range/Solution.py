class Solution:
    def closestPrimes(self, left: int, right: int) -> List[int]:
        primes = [False] * (right + 1)
        for i in range(2, right + 1):
            if not primes[i]:
                for j in range(i * i, right + 1, i):
                    primes[j] = True

        ans = None
        last = -1
        for i in range(max(left, 2), right + 1):
            if not primes[i]:
                if last != -1 and (not ans or ans[1] - ans[0] > i - last):
                    ans = [last, i]
                last = i
        return [-1, -1] if not ans else ans