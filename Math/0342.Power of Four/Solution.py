class Solution:
    def isPowerOfFour(self, n: int) -> bool:
        if n < 1:
            return False
        while not n % 4:
            n //= 4
        return n == 1