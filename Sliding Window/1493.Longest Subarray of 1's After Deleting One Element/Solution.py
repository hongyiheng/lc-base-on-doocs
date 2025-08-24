class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        ans = s = l = 0
        for r, v in enumerate(nums):
            s += v & 1
            while s <= r - l - 1:
                s -= nums[l] & 1
                l += 1
            ans = max(ans, r - l)
        return ans