class Solution:
    def baseNeg2(self, n: int) -> str:
        if n == 0:
            return '0'
        ans = []
        while n:
            if n % -2:
                ans.append('1')
                n -= 1
            else:
                ans.append('0')
            n //= -2
        return "".join(ans)[::-1]