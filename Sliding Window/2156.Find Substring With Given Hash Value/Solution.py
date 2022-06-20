class Solution:
    def subStrHash(self, s: str, power: int, modulo: int, k: int, hashValue: int) -> str:
        def ksm(a, b, m):
            ans, base = 1, a
            while b:
                if b & 1:
                    ans = ans * base % m
                base = base * base % m
                b >>= 1
            return ans % m

        n, cur, base = len(s), 0, 1
        for i in range(n - k, n):
            cur = cur + (ord(s[i]) - ord('a') + 1) * base
            base = base * power % modulo
        cur %= modulo
        last_power = ksm(power, k - 1, modulo)
        ans = n - k
        for i in range(n - k - 1, -1, -1):
            cur = (cur - (ord(s[i + k]) - ord('a') + 1) * last_power % modulo + modulo) % modulo
            cur = ((ord(s[i]) - ord('a') + 1) % modulo + cur * power + modulo) % modulo
            if cur == hashValue:
                ans = i
        return s[ans:ans + k]