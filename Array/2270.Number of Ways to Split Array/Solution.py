class Solution:
    def waysToSplitArray(self, nums: List[int]) -> int:
        s = sum(nums)
        ans = cur = 0
        for i in range(len(nums) - 1):
            cur += nums[i]
            s -= nums[i]
            if cur >= s:
                ans += 1
        return ans
