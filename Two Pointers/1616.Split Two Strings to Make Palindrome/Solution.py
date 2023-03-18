class Solution:
    def checkPalindromeFormation(self, a: str, b: str) -> bool:
        def check(a, b):
            l, r = 0, len(a) - 1
            while l < r and a[l] == b[r]:
                l += 1
                r -= 1
            return l >= r or check2(a, l, r) or check2(b, l, r)

        def check2(s, l, r):
            return s[l: r + 1] == s[l: r + 1][::-1]

        return check(a, b) or check(b, a)