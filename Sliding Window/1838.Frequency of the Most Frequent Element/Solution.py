class Solution:
    def maxFrequency(self, nums: List[int], k: int) -> int:
        nums.sort()
        left, right, ans, n = 0, 1, 1, len(nums)
        need = 0
        while right < n:
            need += (right - left) * (nums[right] - nums[right - 1])
            while need > k:
                need -= (nums[right] - nums[left])
                left += 1
            ans = max(ans, right - left + 1)
            right += 1
        return ans