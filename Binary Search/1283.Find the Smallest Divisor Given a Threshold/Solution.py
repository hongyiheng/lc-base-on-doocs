class Solution:
    def smallestDivisor(self, nums: List[int], threshold: int) -> int:
        def check(x):
            nonlocal nums, threshold
            ans = 0
            for v in nums:
                ans += (v + x - 1) // x
            return ans <= threshold

        left, right = 1, max(nums)
        while left < right:
            mid = (left + right) >> 1
            if check(mid):
                right = mid
            else:
                left = mid + 1
        return left