class Solution:
    def monkeyMove(self, n: int) -> int:
        mod = int(1e9 + 7)
        ans, base = 1, 2
        while n:
            if n & 1:
                ans = ans * base % mod
            base = base * base % mod
            n >>= 1
        return (ans - 2 + mod) % mod