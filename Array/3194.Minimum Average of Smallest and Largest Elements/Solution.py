class Solution:
    def minimumAverage(self, nums: List[int]) -> float:
        nums.sort()
        l, r = 0, len(nums) - 1
        ans = nums[-1]
        while l < r:
            ans = min(ans, (nums[l] + nums[r]) / 2)
            r -= 1
            l += 1
        return ans