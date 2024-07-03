class Solution:
    def sumOfTheDigitsOfHarshadNumber(self, x: int) -> int:
        s, v = 0, x
        while v:
            s += v % 10
            v //= 10
        return s if x % s == 0 else -1
