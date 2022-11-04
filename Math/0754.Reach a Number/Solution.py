class Solution:
    def reachNumber(self, target: int) -> int:
        target = abs(target)
        ans, cur = 1, 1
        while cur < target:
            ans += 1
            cur += ans
        diff = cur - target
        while diff % 2 != 0:
            ans += 1
            cur += ans
            diff = cur - target
        return ans
