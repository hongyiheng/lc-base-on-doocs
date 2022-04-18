class Solution:
    def minDays(self, bloomDay: List[int], m: int, k: int) -> int:
        def check(x, m):
            nonlocal k
            cur = 0
            for v in bloomDay:
                if v <= x:
                    cur += 1
                else:
                    cur = 0
                if cur == k:
                    cur = 0
                    m -= 1
            return m <= 0

        left, right = 0, max(bloomDay)
        while left < right:
            mid = (left + right) >> 1
            if check(mid, m):
                right = mid
            else:
                left = mid + 1
        return left if check(left, m) else -1