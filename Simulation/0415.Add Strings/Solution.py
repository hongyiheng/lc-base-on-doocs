class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        m, n = len(num1) - 1, len(num2) - 1
        carry = False
        ans = []
        while m >= 0 or n >= 0:
            v = 1 if carry else 0
            if m >= 0:
                v += int(num1[m])
            if n >= 0:
                v += int(num2[n])
            carry = v >= 10
            ans.append(str(v % 10))
            m -= 1
            n -= 1
        if carry:
            ans.append("1")
        return "".join(ans[::-1])