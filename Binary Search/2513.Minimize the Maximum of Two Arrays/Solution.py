class Solution:
    def minimizeSet(self, divisor1: int, divisor2: int, uniqueCnt1: int, uniqueCnt2: int) -> int:
        def check(x):
            cnt1 = x - x // divisor1
            cnt2 = x - x // divisor2
            common = x - x // lcm
            return cnt1 >= uniqueCnt1 and cnt2 >= uniqueCnt2 and common >= uniqueCnt1 + uniqueCnt2

        lcm = math.lcm(divisor1, divisor2)
        l, r = 0, 0x3f3f3f3f * 2
        while l < r:
            mid = (l + r) >> 1
            if not check(mid):
                l = mid + 1
            else:
                r = mid
        return r