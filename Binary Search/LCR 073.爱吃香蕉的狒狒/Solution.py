class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        def check(t):
            return sum([(x + t - 1) // t for x in piles]) <= h

        n = len(piles)
        l, r = 1, max(piles)
        while l < r:
            mid = (l + r) >> 1
            if not check(mid):
                l = mid + 1
            else:
                r = mid
        return r