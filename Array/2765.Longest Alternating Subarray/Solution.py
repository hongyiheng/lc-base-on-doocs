class Solution:
    def alternatingSubarray(self, nums: List[int]) -> int:
        ans = cur = 0
        for i in range(1, len(nums)):
            if nums[i - 1] + 1 == nums[i] or nums[i - 1] - 1 == nums[i]:
                if cur and i >= 2 and nums[i - 2] == nums[i]:
                    cur += 1
                elif nums[i - 1] + 1 == nums[i]:
                    cur = 2
                else:
                    cur = 0
            ans = max(ans, cur)
        return -1 if not ans else ans
