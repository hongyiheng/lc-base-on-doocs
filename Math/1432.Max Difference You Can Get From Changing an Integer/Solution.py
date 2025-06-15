class Solution:
    def maxDiff(self, num: int) -> int:
        a = b = av = bv = -1
        mx = mi = 0
        s = str(num)
        for i, c in enumerate(s):
            v = int(c)
            if i == 0 and v != 1 and b == -1:
                b = v
                bv = 1
            if i and v and c != s[0] and b == -1:
                b = v
                bv = 0
            if v != 9 and a == -1:
                a = v
                av = 9
            mx = mx * 10 + (av if v == a else v)
            mi = mi * 10 + (bv if v == b else v)
        return mx - mi



