class Solution:
    def arrangeCoins(self, n: int) -> int:
        left, right = 0, n
        while left < right:
            mid = (left + right + 1) >> 1
            if (1 + mid) * mid // 2 > n:
                right = mid - 1
            else:
                left = mid
        return left