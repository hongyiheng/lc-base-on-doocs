class Solution:
    def nthMagicalNumber(self, n: int, a: int, b: int) -> int:
        def gcd(a, b):
            if b == 0:
                return a
            return gcd(b, a % b)

        mod = int(1e9 + 7)
        if a > b:
            return self.nthMagicalNumber(n, b, a)
        c = a * b // gcd(a, b)
        left, right = 0, a * n
        while left < right:
            mid = (left + right) >> 1
            if mid // a + mid // b - mid // c < n:
                left = mid + 1
            else:
                right = mid
        return left % mod
