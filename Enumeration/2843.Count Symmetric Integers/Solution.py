class Solution:
    def countSymmetricIntegers(self, low: int, high: int) -> int:
        ans = 0
        for i in range(low, high + 1):
            s = str(i)
            n = len(s)
            if n % 2:
                continue
            a = b = 0
            for j in range(n // 2):
                a += int(s[j])
                b += int(s[j + n // 2])
            if a == b:
                ans += 1
        return ans