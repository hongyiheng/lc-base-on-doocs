class Solution:
    def countHillValley(self, nums: List[int]) -> int:
        last = nums[0]
        ans = 0
        for i in range(1, len(nums) - 1):
            if nums[i] == nums[i + 1]:
                continue
            if (last < nums[i] > nums[i + 1]) or (last > nums[i] < nums[i + 1]):
                ans += 1
            last = nums[i]
        return ans