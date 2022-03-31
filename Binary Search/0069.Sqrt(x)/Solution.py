class Solution:
    def mySqrt(self, x: int) -> int:
        left, right = 0, x
        while left < right:
            mid = (left + right + 1) >> 1
            if mid * mid <= x:
                left = mid
            else:
                right = mid - 1
        return left