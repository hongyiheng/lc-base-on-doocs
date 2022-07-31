class Solution:
    def maximumCandies(self, candies: List[int], k: int) -> int:
        def check(x):
            nonlocal candies, k
            cnt = 0
            for v in candies:
                cnt += v // x
            return cnt >= k

        left, right = 0, max(candies)
        while left < right:
            mid = (left + right + 1) >> 1
            if check(mid):
                left = mid
            else:
                right = mid - 1
        return left