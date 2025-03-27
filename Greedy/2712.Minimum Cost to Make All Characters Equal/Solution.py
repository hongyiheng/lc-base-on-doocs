class Solution:
    def minimumCost(self, s: str) -> int:
        def f(t):
            n = len(s)
            ans = d = 0
            for i in range(n // 2, -1, -1):
                v = ord(s[i]) - ord('0')
                if v ^ d != t:
                    ans += i + 1
                    d ^= 1
            d = 0
            for i in range(n // 2, n):
                v = ord(s[i]) - ord('0')
                if v ^ d != t:
                    ans += n - i
                    d ^= 1
            return ans

        return min(f(0), f(1))
