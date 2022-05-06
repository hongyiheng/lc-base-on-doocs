class Solution:
    def missingElement(self, nums: List[int], k: int) -> int:
        def getLack(x):
            nonlocal nums
            return nums[x] - nums[0] - x

        left, right = 0, len(nums) - 1
        while left < right:
            mid = (left + right + 1) >> 1
            if getLack(mid) < k:
                left = mid
            else:
                right = mid - 1
        return nums[left] - getLack(left) + k