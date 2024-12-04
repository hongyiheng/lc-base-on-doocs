class Solution:
    def minNumberOfSeconds(self, mountainHeight: int, workerTimes: List[int]) -> int:
        def check(x):
            h = 0
            for t in workerTimes:
                l, r = 0, mountainHeight
                while l < r:
                    mid = (l + r + 1) >> 1
                    if t * mid * (mid + 1) // 2 <= x:
                        l = mid
                    else:
                        r = mid - 1
                h += r
            return h >= mountainHeight

        l, r = 0, (1 + mountainHeight) * mountainHeight // 2 * workerTimes[0]
        while l < r:
            mid = (l + r) >> 1
            if check(mid):
                r = mid
            else:
                l = mid + 1
        return r

