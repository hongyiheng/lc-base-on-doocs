class Solution:
    def specialArray(self, nums: List[int]) -> int:
        n = len(nums)
        nums.sort()
        for i in range(n + 1):
            left, right = 0, n
            while left < right:
                mid = (left + right) >> 1
                if nums[mid] < i:
                    left = mid + 1
                else:
                    right = mid
            if n - left == i:
                return i
        return -1