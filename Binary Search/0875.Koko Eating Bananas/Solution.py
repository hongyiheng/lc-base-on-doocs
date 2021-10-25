class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        left, right = 1, max(piles)

        def check(speed):
            cost = 0
            for num in piles:
                cost += (num + speed - 1) // speed
            return cost <= h

        while left < right:
            mid = (left + right) >> 1
            if check(mid):
                right = mid
            else:
                left = mid + 1
        return left