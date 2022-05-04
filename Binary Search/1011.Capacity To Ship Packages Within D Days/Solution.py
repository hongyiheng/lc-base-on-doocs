class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        def check(k):
            nonlocal weights, days
            cur, use_day = 0, 1
            for w in weights:
                if w > k:
                    return False
                cur += w
                if cur > k:
                    cur = w
                    use_day += 1
            return use_day <= days

        left, right = 0, 0x7fffffff
        while left < right:
            mid = (left + right) >> 1
            if check(mid):
                right = mid
            else:
                left = mid + 1
        return left