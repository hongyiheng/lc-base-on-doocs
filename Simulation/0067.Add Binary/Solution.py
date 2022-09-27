class Solution:
    def addBinary(self, a: str, b: str) -> str:
        n, m = len(a) - 1, len(b) - 1
        e = False
        ans = ""
        while n >= 0 or m >= 0:
            cur = 1 if e else 0
            e = False
            if n >= 0 and a[n] == "1":
                cur += 1
            if m >= 0 and b[m] == "1":
                cur += 1
            if cur >= 2:
                cur -= 2
                e = True
            ans = str(cur) + ans
            n -= 1
            m -= 1
        return "1" + ans if e else ans
