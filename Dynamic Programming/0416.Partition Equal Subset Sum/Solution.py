class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        n, total = len(nums), sum(nums)
        if total % 2 != 0:
            return False
        mid = total >> 1
        dp = [[0] * (mid + 1) for _ in range(n)]
        for i in range(mid + 1):
            dp[0][i] = nums[0] if i >= nums[0] else 0
        for i in range(1, n):
            t = nums[i]
            for j in range(mid + 1):
                a = dp[i - 1][j]
                b = dp[i - 1][j - t] + t if j >= t else 0
                dp[i][j] = max(a, b)
        return dp[n - 1][mid] == mid