class Solution:
    def countQuadruplets(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [[[0] * (4) for _ in range(101)] for _ in range(n + 1)]
        dp[0][0][0] = 1
        for i in range(1, n + 1):
            c = nums[i - 1]
            for j in range(101):
                for k in range(4):
                    dp[i][j][k] = dp[i - 1][j][k]
                    if j >= c and k >= 1:
                        dp[i][j][k] += dp[i - 1][j - c][k - 1]
        ans = 0
        for i in range(3, n):
            ans += dp[i][nums[i]][3]
        return ans
