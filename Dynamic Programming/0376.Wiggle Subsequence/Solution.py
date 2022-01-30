class Solution:
    def wiggleMaxLength(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [[0] * 2 for _ in range(n)]
        dp[0][0] = dp[0][1] = 1
        for i in range(1, n):
            if nums[i] > nums[i - 1]:
                dp[i][1] = dp[i - 1][0] + 1
            else:
                dp[i][1] = dp[i - 1][1]
            if nums[i] < nums[i - 1]:
                dp[i][0] = dp[i - 1][1] + 1
            else:
                dp[i][0] = dp[i - 1][0]
        return max(dp[n - 1][0], dp[n - 1][1])