class Solution:
    def countHillValley(self, nums: List[int]) -> int:
        n = len(nums)
        i, ans = 0, 0
        while i < n:
            left, right = i - 1, i + 1
            while left > 0 and nums[left] == nums[i]:
                left -= 1
            while right < n and nums[right] == nums[i]:
                right += 1
            if left < 0 or right >= n:
                i += 1
                continue
            if nums[left] < nums[i] and nums[right] < nums[i]:
                ans += 1
            if nums[left] > nums[i] and nums[right] > nums[i]:
                ans += 1
            i = right
        return ans