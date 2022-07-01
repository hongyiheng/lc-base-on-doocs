class Solution:
    def minimumTime(self, time: List[int], totalTrips: int) -> int:
        def check(k):
            nonlocal totalTrips, time
            cnt = 0
            for t in time:
                cnt += k // t
            return cnt >= totalTrips

        min_time = min(time)
        left, right = 0, min_time * totalTrips
        while left < right:
            mid = (left + right) >> 1
            if check(mid):
                right = mid
            else:
                left = mid + 1
        return left