class Solution:
    def poorPigs(self, buckets: int, minutesToDie: int, minutesToTest: int) -> int:
        times = minutesToTest // minutesToDie + 1
        left, right = 0, 1000
        while left < right:
            mid = (left + right) >> 1
            if times ** mid < buckets:
                left = mid + 1
            else:
                right = mid
        return left