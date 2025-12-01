class Solution:
    def maxRunTime(self, n: int, batteries: List[int]) -> int:
        def check(x):
            idx = bisect.bisect_left(batteries, x)
            k = m - idx
            if k >= n:
                return True
            return pre[idx] >= (n - k) * x

        m = len(batteries)
        batteries.sort()
        pre = [0]
        for v in batteries:
            pre.append(pre[-1] + v)
        l, r = 0, sum(batteries) // n
        ans = 0
        while l < r:
            mid = (l + r + 1) >> 1
            if check(mid):
                l = mid
            else:
                r = mid - 1
        return r