class Solution:
    def maxValue(self, n: int, index: int, maxSum: int) -> int:
        def get_cnt(x, m):
            return m - x + (x + 1) * x / 2 if m >= x else (x + x - m + 1) * m / 2

        left, right = 1, maxSum
        while left < right:
            mid = (left + right + 1) >> 1
            if get_cnt(mid, index + 1) + get_cnt(mid, n - index) - mid <= maxSum:
                left = mid
            else:
                right = mid - 1
        return left