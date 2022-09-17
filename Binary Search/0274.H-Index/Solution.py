class Solution:
    def hIndex(self, citations: List[int]) -> int:
        def check(x):
            cnt = 0
            for v in citations:
                if v >= x:
                    cnt += 1
            return cnt >= x

        left, right = 0, 1000
        while left < right:
            mid = (left + right + 1) >> 1
            if check(mid):
                left = mid
            else:
                right = mid - 1
        return left