class Solution:
    def pivotInteger(self, n: int) -> int:
        pre = suf = 0
        suf = sum(i for i in range(n + 1))
        for i in range(n + 1):
            pre += i
            if pre == suf:
                return i
            suf -= i
        return -1