class Solution:
    def subtractProductAndSum(self, n: int) -> int:
        a, b = 1, 0
        while n:
            v = n % 10
            n //= 10
            a *= v
            b += v
        return a - b
