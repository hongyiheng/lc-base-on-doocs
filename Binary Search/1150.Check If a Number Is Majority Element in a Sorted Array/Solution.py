class Solution:
    def isMajorityElement(self, nums: List[int], target: int) -> bool:
        left, right = 0, len(nums) - 1
        while left < right:
            mid = (left + right + 1) >> 1
            if nums[mid] < target:
                left = mid
            else:
                right = mid - 1
        t_start = left if nums[left] == target else left + 1
        left, right = 0, len(nums) - 1
        while left < right:
            mid = (left + right) >> 1
            if nums[mid] <= target:
                left = mid + 1
            else:
                right = mid
        t_end = left if nums[left] == target else left - 1
        return (t_end - t_start + 1) * 2 > len(nums)