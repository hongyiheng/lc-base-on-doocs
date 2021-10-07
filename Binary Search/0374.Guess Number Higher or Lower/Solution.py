# The guess API is already defined for you.
# @param num, your guess
# @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
# def guess(num: int) -> int:

class Solution:
    def guessNumber(self, n: int) -> int:
        left, right = 0, n
        while left < right:
            mid = (left + right) // 2
            if guess(mid) == 1:
                left = mid + 1
            else:
                right = mid
        return left