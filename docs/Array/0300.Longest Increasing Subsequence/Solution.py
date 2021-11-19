class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        m = len(nums)
        dp = [0] * m
        dp[0] = 1

        def getLastMax(i):
            cur = nums[i]
            last_max = 0
            for i in range(i - 1, -1, -1):
                if nums[i] < cur:
                    last_max = max(last_max, dp[i])
            return last_max

        for i in range(1, m):
            last_max = getLastMax(i)
            dp[i] = last_max + 1
        return max(dp)
