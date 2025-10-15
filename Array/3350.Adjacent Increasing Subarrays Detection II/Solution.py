class Solution:
    def maxIncreasingSubarrays(self, nums: List[int]) -> int:
        ans = s = 1
        last = 0
        for i in range(1, len(nums)):
            if nums[i] > nums[i - 1]:
                s += 1
            else:
                ans = max(ans, s // 2, min(last, s))
                last = s
                s = 1
        return max(ans, s // 2, min(last, s))