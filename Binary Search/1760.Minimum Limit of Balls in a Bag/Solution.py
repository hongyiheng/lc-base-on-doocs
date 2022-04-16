class Solution:
    def minimumSize(self, nums: List[int], maxOperations: int) -> int:
        def check(x, k):
            nonlocal nums
            for v in nums:
                k -= (v - 1) // x
            return k >= 0

        left, right = 1, max(nums)
        while left < right:
            mid = (left + right) >> 1
            if check(mid, maxOperations):
                right = mid
            else:
                left = mid + 1
        return left