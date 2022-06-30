class Solution:
    def numPrimeArrangements(self, n: int) -> int:
        primes = [0] * (n + 1)
        idx, cnt = 2, 1
        while idx * idx <= n:
            if primes[idx] == 0:
                for j in range(idx * idx, n + 1, idx):
                    if primes[j] == 0:
                        primes[j] = 1
                        cnt += 1
            idx += 1
        prime_num = n - cnt
        ans, mod = 1, int(1e9 + 7)
        for i in range(prime_num, 0, -1):
            ans = ans * i % mod
        for i in range(cnt, 0, -1):
            ans = ans * i % mod
        return int(ans % mod)
