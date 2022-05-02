class Solution:
    def twoSumLessThanK(self, nums: List[int], k: int) -> int:
        nums.sort()
        ans = -1
        for i, v in enumerate(nums):
            left, right = 0, len(nums) - 1
            while left < right:
                mid = (left + right + 1) >> 1
                if nums[mid] + v < k:
                    left = mid
                else:
                    right = mid - 1
            if nums[left] + v < k and left != i:
                ans = max(ans, nums[left] + v)
        return ans