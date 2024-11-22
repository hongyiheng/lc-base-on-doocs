class Solution:
    def nonSpecialCount(self, l: int, r: int) -> int:
        def get_primes():
            n = 34000
            primes = [False] * n
            for i in range(2, n):
                if not primes[i]:
                    for j in range(i * i, n, i):
                        primes[j] = True
            primes[1] = True
            return primes

        primes = get_primes()
        ans = r - l + 1
        for i in range(int(math.sqrt(l)), int(math.sqrt(r)) + 1):
            if l <= i * i <= r and not primes[i]:
                print(i)
                ans -= 1
        return ans


