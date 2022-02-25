class Solution:
    def complexNumberMultiply(self, num1: str, num2: str) -> str:
        a1 = int(num1.split("+")[0])
        a2 = int(num1.split("+")[1][:-1])
        b1 = int(num2.split("+")[0])
        b2 = int(num2.split("+")[1][:-1])
        return str(a1 * b1 - a2 * b2) + "+" + str(a1 * b2 + a2 * b1) + "i"