class Solution:
    def maxPossibleScore(self, start: List[int], d: int) -> int:
        def check(x):
            last = start[0]
            for i in range(1, len(start)):
                if last + x > start[i] + d:
                    return False
                last = max(last + x, start[i])
            return True

        start.sort()
        l, r = 0, start[-1] - start[0] + 2 * d
        while l < r:
            mid = (l + r + 1) >> 1
            if check(mid):
                l = mid
            else:
                r = mid - 1
        return r
