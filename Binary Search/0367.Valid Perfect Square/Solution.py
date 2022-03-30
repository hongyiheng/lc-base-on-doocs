class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        left, right = 1, num // 2
        while left < right:
            mid = (left + right) >> 1
            if mid * mid < num:
                left = mid  +1
            else:
                right = mid
        return left * left == num