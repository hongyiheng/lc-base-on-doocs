class Solution:
    def findMin(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1
        while left < right:
            mid = (left + right) >> 1
            if nums[mid] < nums[left]:
                right = mid
            elif nums[mid] > nums[right]:
                left = mid + 1
            else:
                return nums[left]
        return nums[left]