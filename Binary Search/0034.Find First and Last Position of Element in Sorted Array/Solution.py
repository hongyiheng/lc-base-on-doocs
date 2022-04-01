class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        ans = [-1] * 2
        if len(nums) == 0:
            return ans
        left, right = 0, len(nums) - 1
        while left < right:
            mid = (left + right) >> 1
            if nums[mid] < target:
                left = mid + 1
            else:
                right = mid
        if nums[left] == target:
            ans[0] = left
        else:
            return ans
        left, right = 0, len(nums) - 1
        while left < right:
            mid = (left + right + 1) >> 1
            if nums[mid] <= target:
                left = mid
            else:
                right = mid - 1
        ans[1] = left
        return ans