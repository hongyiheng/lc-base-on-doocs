class Solution:
    def countSubarrays(self, nums: List[int]) -> int:
        ans = 0
        for i, v in enumerate(nums[2:], 2):
            if (v + nums[i - 2]) * 2 == nums[i - 1]:
                ans += 1
        return ans
        