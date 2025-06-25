
class Solution:
    def maxProduct(self, n: int) -> int:
        mx = ans = 0
        while n:
            v = n % 10
            ans = max(ans, v * mx)
            mx = max(mx, v)
            n //= 10
        return ans