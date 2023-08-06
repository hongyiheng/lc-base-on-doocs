class Solution:
    def findValueOfPartition(self, nums: List[int]) -> int:
        nums.sort()
        ans = inf
        for i in range(1, len(nums)):
            ans = min(nums[i] - nums[i - 1], ans)
        return ans