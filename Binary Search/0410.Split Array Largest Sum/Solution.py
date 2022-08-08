class Solution:
    def splitArray(self, nums: List[int], m: int) -> int:
        def check(x):
            nonlocal nums, m
            cnt = cur = 0
            for v in nums:
                if v > x:
                    return False
                cur += v
                if cur > x:
                    cur = v
                    cnt += 1
            return cnt + 1 <= m

        left, right = 0, sum(nums)
        while left < right:
            mid = (left + right) >> 1
            if check(mid):
                right = mid
            else:
                left = mid + 1
        return left