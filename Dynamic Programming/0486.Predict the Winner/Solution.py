class Solution:
    def PredictTheWinner(self, nums: List[int]) -> bool:
        n = len(nums)
        dp = [[0 for _ in range(n + 3)] for _ in range(n + 3)]
        for m in range(1, n + 1):
            for l in range(1, n - m + 2):
                r = l + m - 1;
                a = nums[l - 1] - dp[l + 1][r]
                b = nums[r - 1] - dp[l][r - 1]
                dp[l][r] = max(a, b)
        return dp[1][n] >= 0