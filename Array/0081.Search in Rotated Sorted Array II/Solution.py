class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        n = len(nums)
        l, r = 0, n - 1
        while l < r:
            mid = (l + r) >> 1
            if nums[mid] == target:
                return True
            if nums[l] == nums[mid]:
                l += 1
                continue
            if nums[mid] == nums[r]:
                r -= 1
                continue
            if nums[l] <= nums[mid]:
                if nums[l] <= target < nums[mid]:
                    r = mid
                else:
                    l = mid + 1
            else:
                if nums[mid] < target <= nums[r]:
                    l = mid + 1
                else:
                    r = mid
        return n > 0 and nums[r] == target
                    