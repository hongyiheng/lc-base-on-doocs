class Solution:
    def generateKey(self, num1: int, num2: int, num3: int) -> int:
        ans, i = 0, 1
        while num1 or num2 or num3:
            v = num1 % 10 if num1 else 0
            v = min(v, num2 % 10 if num2 else 0)
            v = min(v, num3 % 10 if num3 else 0)
            num1 //= 10
            num2 //= 10
            num3 //= 10
            ans = ans + v * i
            i *= 10
        return ans