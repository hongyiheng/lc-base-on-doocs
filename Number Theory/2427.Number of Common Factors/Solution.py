class Solution:
    def commonFactors(self, a: int, b: int) -> int:
        def gcd(x, y):
            if not y:
                return x
            return gcd(y, x % y)

        g = gcd(a, b)
        i, ans = 1, 0
        while i * i <= g:
            if g % i == 0:
                ans += 1
                if i * i != g:
                    ans += 1
            i += 1
        return ans
