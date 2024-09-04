class Solution:
    def countWays(self, nums: List[int]) -> int:
        nums.sort()
        ans = 1 if nums[0] > 0 else 0
        for i, v in enumerate(nums):
            if v < i + 1:
                if i < len(nums) - 1 and nums[i + 1] <= i + 1:
                    continue
                ans += 1
        return ans