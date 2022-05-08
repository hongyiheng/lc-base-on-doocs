class Solution:
    def maxLength(self, ribbons: List[int], k: int) -> int:
        def check(m):
            nonlocal ribbons, k
            cnt = 0
            for v in ribbons:
                cnt += v // m
                if cnt >= k:
                    return True
            return False

        left, right = 0, 100000
        while left < right:
            mid = (left + right + 1) >> 1
            if check(mid):
                left = mid
            else:
                right = mid - 1
        return left