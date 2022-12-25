class Solution:
    def minimumBoxes(self, n: int) -> int:
        bottom = incr = s = 0
        while s < n:
            incr += 1
            bottom += incr
            s += bottom
        if s == n:
            return bottom
        s -= bottom
        bottom -= incr
        extra = 0
        while s < n:
            extra += 1
            s += extra
        return extra + bottom