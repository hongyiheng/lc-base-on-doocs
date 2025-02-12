class Solution:
    def minimumSize(self, nums: List[int], maxOperations: int) -> int:
        def check(x):
            ans = 0
            for v in nums:
                if v > x:
                    ans += (v - 1) // x
                if ans > maxOperations:
                    return False
            return True

        l, r = 1, max(nums)
        while l < r:
            mid = (l + r) >> 1
            if check(mid):
                r = mid
            else:
                l = mid + 1
        return r