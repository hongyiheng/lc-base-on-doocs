class Solution:
    def minimumAverage(self, nums: List[int]) -> float:
        nums.sort()
        ans = nums[-1]
        l, r = 0, len(nums) - 1
        while l < r:
            ans = min(ans, (nums[l] + nums[r]) / 2)
            l += 1
            r -= 1
        return ans
